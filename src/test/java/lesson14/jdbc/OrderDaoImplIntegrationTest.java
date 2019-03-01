package lesson14.jdbc;
/**
 * @author spasko
 */

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplIntegrationTest {
	private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(-1);
	private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(113007);
	private static final Order ORDER = new Order(BigDecimal.valueOf(12345), null, new Date(), null,
			BigDecimal.valueOf(-1), null);
	private OrderDao orderDao = new OrderDaoImpl();

	@Test
	public void testGetAllOrders() throws SQLException {
		Set<Order> orders = orderDao.getAllOrders();
		System.out.println(orders);
		assertTrue(orders.size() > 15);
	}

	@Test
	public void testFindOrderByIdNotPresent() throws SQLException {
		Order order = orderDao.findOrderById(NOT_EXIST_ORDER);
		System.out.println(order);
		assertNull(order);
	}

	@Test
	public void testFindOrderById() throws SQLException {
		Order order = orderDao.findOrderById(ALREADY_EXIST_ORDER);
		System.out.println(order);
		assertNotNull(order);
	}

	@Test
	public void test1insertOrder() throws SQLException {
		assertTrue(orderDao.insertOrder(ORDER));
	}

	@Test
	public void test2updateOrder() throws SQLException {
		ORDER.setAmount(BigDecimal.valueOf(-333));
		ORDER.setQty(BigDecimal.valueOf(-111));
		assertTrue(orderDao.updateOrder(ORDER));
	}

	@Test
	public void test3deleteOrder() throws SQLException {
		assertTrue(orderDao.deleteOrder(ORDER.getOrderNum()));
	}

}
