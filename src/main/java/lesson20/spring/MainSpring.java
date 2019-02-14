package lesson20.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lesson20.spring.entity.Panda;
import lesson20.spring.entity.Tiger;

/**
 * @author spasko
 */
public class MainSpring {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("lesson20");

		Tiger bigCat = context.getBean(Tiger.class);
		System.out.println(bigCat);

		Panda panda = context.getBean(Panda.class);
		System.out.println(panda);
		context.close();
	}
}
