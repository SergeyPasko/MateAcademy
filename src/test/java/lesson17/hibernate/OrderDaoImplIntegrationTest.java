package lesson17.hibernate;
/**
 * @author spasko
 */

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import lesson16.entry.Orders;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplIntegrationTest {
	private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(-1);
	private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(113013);
	private static final Orders ORDER = new Orders(BigDecimal.valueOf(113034), null, null, null, new Date(), null,
			BigDecimal.valueOf(-1), null);
	private OrderDao orderDao = new OrderDaoImpl();

	@Test
	public void testGetAllOrders() {
		Set<Orders> orders = orderDao.getAllOrders();
		System.out.println(orders);
		assertTrue(orders.size() > 15);
	}

	@Test
	public void testFindOrderByIdNotPresent() {
		Orders order = orderDao.findOrderById(NOT_EXIST_ORDER);
		assertNull(order);
	}

	@Test
	public void testFindOrderById() {
		Orders order = orderDao.findOrderById(ALREADY_EXIST_ORDER);
		assertNotNull(order);
	}

	@Test
	public void test1insertOrder() {
		assertTrue(orderDao.insertOrder(ORDER));
	}

	@Test
	public void test2updateOrder() {
		ORDER.setAmount(BigDecimal.valueOf(-333));
		ORDER.setQty(BigDecimal.valueOf(-111));
		assertTrue(orderDao.updateOrder(ORDER));
	}

	@Test
	public void test3deleteOrder() {
		assertTrue(orderDao.deleteOrder(ORDER.getOrderNum()));
	}

}
