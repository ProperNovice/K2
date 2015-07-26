package utils;

import javafx.application.Platform;

import com.sun.javafx.tk.Toolkit;

public class Lock {

	public static Object lockObject = new Object();
	private static LockType lockType = null;

	private Lock() {

	}

	private enum LockType {
		FX, EXECUTOR_SERVICE
	}

	private static Semaphore semaphore = new Semaphore();

	private static class Semaphore {

		private java.util.concurrent.Semaphore semaphore = null;

		public Semaphore() {
			this.semaphore = new java.util.concurrent.Semaphore(0);
		}

		public void releasePermit() {
			this.semaphore.release();
		}

		public void acquirePermit() {

			try {
				this.semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		public int availablePermits() {
			return this.semaphore.availablePermits();
		}

	}

	public static void lock() {

		Logger.log("lock");

		if (Platform.isFxApplicationThread()) {

			lockType = LockType.FX;
			Toolkit.getToolkit().enterNestedEventLoop(lockObject);

		} else if (!Platform.isFxApplicationThread()) {

			lockType = LockType.EXECUTOR_SERVICE;
			semaphore.acquirePermit();

		}

		Logger.logNewLine("unlock");

		if (!Platform.isFxApplicationThread())
			Logger.logNewLine("available permits : "
					+ semaphore.availablePermits());

	}

	public static void unlock() {

		if (lockType.equals(LockType.FX))
			Toolkit.getToolkit().exitNestedEventLoop(lockObject, lockObject);

		else if (lockType.equals(LockType.EXECUTOR_SERVICE))
			semaphore.releasePermit();

	}

}
