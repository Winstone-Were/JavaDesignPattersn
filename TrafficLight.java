
import java.util.ArrayList;
import java.util.List;

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

class Subject{
    private List<Observer> observers  = new ArrayList<Observer>();
    private int state;

    public int getState(){
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    
    public void attach(Observer observer){
        observers.add(observer);
    }


    public void notifyAllObservers(){
        for(Observer observer: observers){
            observer.update();
        }
    }

}

class PedestrianTrafficLight extends Observer {

    PedestrianTrafficLight(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        switch (subject.getState()) {
            case 1:
                System.out.println("Pedestian Stop");
                break;
            case 3:
                System.out.println("Pedestrian Go");
                break;
            default:
                break;
        }
    }
}

class OpposingTrafficLight extends Observer {

    OpposingTrafficLight(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        switch (subject.getState()) {
            case 1:
                System.out.println("Oppsite Stop");
                break;
            case 2:
                System.out.println("Opposite Get Ready");
                break;
            case 3:
                System.out.println("Opposite Go");
                break;    
            default:
                break;
        }
    }
}

public class TrafficLight {

    public static void main(String[] args) {
        Subject RoundaboutLiights = new Subject();

        new PedestrianTrafficLight(RoundaboutLiights);
        new OpposingTrafficLight(RoundaboutLiights);

        System.out.println("Main Lights Go");
        RoundaboutLiights.setState(1);

        System.out.println("Main Lights Get Ready");
        RoundaboutLiights.setState(2);


        System.out.println("Main Lights Stop");
        RoundaboutLiights.setState(3);

    }

}