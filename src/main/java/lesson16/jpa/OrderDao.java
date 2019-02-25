package lesson16.jpa;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import lesson16.entry.Orders;

/**
 * @author spasko
 */
public interface OrderDao {

	Set<Orders> getAllOrders();

	Orders findOrderById(BigDecimal id);

	boolean insertOrder(Orders order);

	boolean updateOrder(Orders order);

	boolean deleteOrder(BigDecimal id);
}
