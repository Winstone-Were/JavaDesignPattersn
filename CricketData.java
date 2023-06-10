
import java.util.ArrayList;
import java.util.Iterator;

interface Subject {
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
}

public class CricketData implements Subject{
    int runs, wickets;
    float overs;
    ArrayList<Observer> observerList;
    
    public CricketData(Observer o){
        observerList.add(o);
    }
    
    public void registerObserver(Observer o) {
        observerList.add(o);
    }
  
    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }
  
    @Override
    public void notifyObservers()
    {
        for (Iterator<Observer> it =
              observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(runs,wickets,overs);
        }
    }

    private int getLatestRuns()
    {
        // return 90 for simplicity
        return 90;
    }
  
    // get latest wickets from stadium
    private int getLatestWickets()
    {
        // return 2 for simplicity
        return 2;
    }
  
    // get latest overs from stadium
    private float getLatestOvers()
    {
        // return 90 for simplicity
        return (float)10.2;
    }
  
    // This method is used update displays
    // when data changes
    public void dataChanged()
    {
        //get latest data
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();
  
        notifyObservers();
    }
}

interface Observer {
    public void update(int runs, int wickets, float overs);
}

class AverageScoreDisplay implements Observer {
    float runRate;
    int predictedScore;

    public void update(int runs, int wickets, float overs){
        this.runRate =(float)runs/overs;
        this.predictedScore = (int)(this.runRate * 50);
        display();
    }

    public void display()
    {
        System.out.println("\nAverage Score Display: \n"
                           + "Run Rate: " + runRate +
                           "\nPredictedScore: " +
                           predictedScore);
    }

}

class CurrentScoreDisplay implements Observer
{
    private int runs, wickets;
    private float overs;
  
    public void update(int runs, int wickets,
                       float overs)
    {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }
  
    public void display()
    {
        System.out.println("\nCurrent Score Display:\n"
                           + "Runs: " + runs +
                           "\nWickets:" + wickets +
                           "\nOvers: " + overs );
    }
}
