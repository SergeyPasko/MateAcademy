package lesson21.springdata;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lesson21.springdata.service.OrdersService;

/**
 * @author spasko
 */
public class MainSpringData {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("lesson21.springdata.config");
		OrdersService ordersService = context.getBean(OrdersService.class);

		ordersService.getAllOrders().forEach(System.out::println);
		System.out.println("----------");
		ordersService.findByQtyBetween(5, 15).forEach(System.out::println);
		System.out.println("----------");
		ordersService.findByQtyBetween(5, 15).forEach(System.out::println);

		context.close();
	}
}
