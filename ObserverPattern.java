
import java.util.ArrayList;
import java.util.List;

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state){
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer: observers){
            observer.update();
        }
    }

}

class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println("Binary String "+Integer.toBinaryString( subject.getState()));
    }
}

class OctalObserver extends Observer {
    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override 
    public void update(){
        System.out.println("Octal String " + Integer.toOctalString(subject.getState()));
    }
}


public class ObserverPattern {
    public static void main(String[] args) {
        /*SingleTonWithoutThreads WorkingObj = SingleTonWithoutThreads.GetInstance();

        WorkingObj.CounterPlus();
        System.out.println(WorkingObj.getCount());*/

       Subject NumberConversion = new Subject();
       
       new BinaryObserver(NumberConversion);
       new OctalObserver(NumberConversion);

       System.out.println("First Change to: 15");
       NumberConversion.setState(15);
       System.out.println("Second change to 10");
       NumberConversion.setState(10);
           
    }
}