package lesson16.hibernate;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

import lesson16.hibernate.entry.Orders;

/**
 * @author spasko
 */
public interface OrderDao {

	Set<Orders> getAllOrders() throws SQLException;

	Orders findOrderById(BigDecimal id) throws SQLException;

	boolean insertOrder(Orders order) throws SQLException;

	boolean updateOrder(Orders order) throws SQLException;

	boolean deleteOrder(BigDecimal id) throws SQLException;
}
