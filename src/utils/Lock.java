package utils;

public class Lock {

	private static Semaphore semaphore = new Semaphore(0);

	public static void lock() {

		Logger.log("lock");
		semaphore.acquirePermit();
		Logger.log("unlock");
		Logger.logNewLine("available permits : " + semaphore.availablePermits());

	}

	public static void unlock() {
		semaphore.releasePermit();
	}

}
