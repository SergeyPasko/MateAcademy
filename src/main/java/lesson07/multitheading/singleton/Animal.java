package lesson07.multitheading.singleton;

/**
 * @author spasko
 */
public abstract class Animal {
	private String name;

	public Animal(String name) {
		System.out.println(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}

}
