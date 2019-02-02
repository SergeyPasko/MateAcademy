package lesson17.hibernate;
/**
 * @author spasko
 */

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Set;

import org.hibernate.ObjectNotFoundException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import lesson16.entry.Orders;
import lesson17.hibernate.OrderDao;
import lesson17.hibernate.OrderDaoImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDaoImplIntegrationTest {
	private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(-1);
	private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(112922);
	private static final Orders ORDER = new Orders(BigDecimal.valueOf(12345), null, null, null, new Date(), null,
			BigDecimal.valueOf(-1), null);
	private OrderDao orderDao = new OrderDaoImpl();

	@Test
	public void testGetAllOrders() throws SQLException {
		Set<Orders> orders = orderDao.getAllOrders();
		System.out.println(orders);
		assertTrue(orders.size() > 15);
	}

	@Test(expected = ObjectNotFoundException.class)
	public void testFindOrderByIdNotPresent() throws SQLException {
		Orders order = orderDao.findOrderById(NOT_EXIST_ORDER);
		System.out.println(order);
	}

	@Test
	public void testFindOrderById() throws SQLException {
		Orders order = orderDao.findOrderById(ALREADY_EXIST_ORDER);
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
