package lesson08.multitheading.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author spasko
 */
public class CountThread implements Runnable {

	AtomicInteger res;
	String name;

	CountThread(AtomicInteger res, String name) {
		this.res = res;
		this.name = name;
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.printf("%s %d \n", name, res.incrementAndGet());
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}