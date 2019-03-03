package lesson22.spring.mvc.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lesson16.entry.Orders;
import lesson22.spring.mvc.dto.OrderRequest;
import lesson22.spring.mvc.util.DtoModelsUtil;

/**
 * @author spasko
 */
public class OrderCreatorTest {

	private OrderCreator orderCreator = new OrderCreatorImpl();

	@Test
	public void testCreateOrder() {
		OrderRequest orderRequest = DtoModelsUtil.orderRequest();
		Orders actual = orderCreator.createOrder(orderRequest);
		Orders expected = DtoModelsUtil.order();
		assertEquals(expected, actual);
	}

}
