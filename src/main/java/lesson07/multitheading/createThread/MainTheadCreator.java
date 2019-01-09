package lesson07.multitheading.createThread;

/**
 * @author spasko
 */
public class MainTheadCreator {
	public static void main(String[] args) {
		Runnable task = () -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		};
		task.run();

		Thread thread = new Thread(task);
		thread.start();

		System.out.println("Done!");
	}
}
