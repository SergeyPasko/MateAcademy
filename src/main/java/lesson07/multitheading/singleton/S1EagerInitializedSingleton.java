package lesson07.multitheading.singleton;

/**
 * @author spasko
 */
public class S1EagerInitializedSingleton extends Animal {

	private static final S1EagerInitializedSingleton instance = new S1EagerInitializedSingleton();

	// private constructor to avoid client applications to use constructor
	private S1EagerInitializedSingleton() {		
		super("S1EagerInitializedSingleton " + System.currentTimeMillis());
	}

	public static S1EagerInitializedSingleton getInstance() {
		return instance;
	}
}
