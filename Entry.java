public class Entry {
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
