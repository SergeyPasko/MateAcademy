package lesson04.genericMethod;

import java.util.List;
import java.util.stream.Collectors;

import lesson04.genericClazz.Animal;
import lesson04.genericClazz.Cat;

/**
 * @author spasko
 */
public class GenericMethodExample {
	public <T> void doSomething(String str, T t) {
		System.out.println(str + "---" + t.toString());
	}

	public <T extends Cat> void doSomethingWithCat(String str, T t) {
		System.out.println(str + " " + t.toString() + " We know exectly it is a " + t.name());
	}

	public void showAnimalNames(List<? extends Animal> animals) {
		animals.forEach(an -> System.out.print(an.name()+" ---"));
	}

	public void showCatParentsNames(List<? super Cat> objects) {
		//objects.add(new Cat());
		//objects.add(new Dog());
		System.out.println(objects.stream().map(Object::toString).collect(Collectors.joining(", ")));
	}
}
