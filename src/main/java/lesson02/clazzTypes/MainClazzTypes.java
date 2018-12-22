package lesson02.clazzTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author spasko
 */
public class MainClazzTypes {
	public static void main(String[] args) {
		List<Animal> animals = new ArrayList<>();
		Animal animal1 = new Animal() {

			@Override
			public boolean weCanEatIt() {
				return false;
			}

			@Override
			public String name() {
				return "Cat";
			}
		};
		animals.add(animal1);

		Animal animal2 = new AnimalExample.Pig();
		animals.add(animal2);

		// Animal animal3 = new AnimalExample.Dog();
		// animals.add(animal3);

		Animal animal4 = new AnimalExample().new Dog();
		animals.add(animal4);

		animals.stream().map(animal -> animal.name() + " - we can eat it? -" + (animal.weCanEatIt() ? "Y" : "N"))
				.forEach(System.out::println);
		;
	}

}
