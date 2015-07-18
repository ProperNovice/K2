package utils;

public class Semaphore {

	private java.util.concurrent.Semaphore semaphore = null;

	public Semaphore(int availablePermits) {
		this.semaphore = new java.util.concurrent.Semaphore(availablePermits);
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
		return semaphore.availablePermits();
	}

}