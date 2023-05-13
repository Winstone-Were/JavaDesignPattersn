    // Thread Synchronized Java implementation of
// singleton design pattern
// Double Checked Locking based Java implementation of
// singleton design pattern
class Singleton
{
	private static volatile Singleton obj = null;
    private int counter = 0;

	private Singleton() {}

	public static Singleton getInstance()
	{
		if (obj == null)
		{
			// To make thread safe
			synchronized (Singleton.class)
			{
				// check again as multiple threads
				// can reach above step
				if (obj==null)
					obj = new Singleton();
			}
		}
		return obj;
	}
}

