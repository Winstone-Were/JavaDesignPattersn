
interface Movable {
    double getSpeed();
}

class BMW implements Movable {
    @Override
    public double getSpeed(){
        return 155;
    }
}

interface MovableAdapter {
    double getSpeed();
}

class MovableAdapterImpl implements MovableAdapter {
    private Movable Car;
    MovableAdapterImpl(Movable x){
        Car = x;
    }

    @Override
    public double getSpeed(){
        return convToMph(Car.getSpeed());
    }

    double convToMph(double i) {
        return i / 1.6;
    }

}