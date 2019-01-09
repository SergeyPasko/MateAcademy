package lesson07.multitheading.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author spasko
 */
public class MainSingleton {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(50);
		List<Callable<String>> tasks = new ArrayList<>();
		for (int i = 0; i < 50; i++)
			tasks.add(() -> S1EagerInitializedSingleton.getInstance().getName());
		executor.invokeAll(tasks);
		executor.shutdown();
	}

}
