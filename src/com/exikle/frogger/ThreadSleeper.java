package com.exikle.frogger;

public class ThreadSleeper {

	public ThreadSleeper(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException ex) {
		}
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

	}
}
