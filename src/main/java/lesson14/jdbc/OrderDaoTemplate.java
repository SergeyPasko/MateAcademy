package lesson14.jdbc;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Set;

/**
 * @author spasko
 */
public interface OrderDaoTemplate {

	Set<Order> getAllOrders() throws SQLException;

	Order findOrderById(BigDecimal id) throws SQLException;

	boolean insertOrder(Order order) throws SQLException;

	boolean updateOrder(Order order) throws SQLException;

	boolean deleteOrder(Order order) throws SQLException;
}
