package lesson03.oop;

/**
 * @author spasko
 */
public class Mouse implements Animal {

	@Override
	public String name() {
		return "Mouse";
	}

	@Override
	public String say() {
		return "Pi";
	}

}
