public class SingleTonWithoutThreads {

    private static SingleTonWithoutThreads obj = null;

    private SingleTonWithoutThreads() {}

    private int counter = 0;

    public static SingleTonWithoutThreads GetInstance() {
        if(obj != null){
                return obj;
        }else {
            return new SingleTonWithoutThreads();
        }
    }

    public void CounterPlus() {
        counter++;
    }

    public int getCount() {
        return counter;
    }

}



