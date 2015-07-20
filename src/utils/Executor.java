package utils;

public class Executor {

	// private static ExecutorService executorService = Executors
	// .newCachedThreadPool();

	private Executor() {

	}

	// public static void runLater(Runnable runnable) {
	// executorService.submit(runnable);
	// }

	public static void sleep(final long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void runLater(Runnable runnable) {
		runnable.run();
	}

}
