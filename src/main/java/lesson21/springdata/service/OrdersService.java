package lesson21.springdata.service;

import java.math.BigDecimal;
import java.util.Set;

import lesson21.springdata.entity.Orders;

/**
 * @author spasko
 */
public interface OrdersService {
	Set<Orders> getAllOrders();

	Set<Orders> findByQtyBetween(int minQty, int maxQty);

	Orders findOrderById(BigDecimal id);

	void insertOrder(Orders order);

	void updateOrder(Orders order);

	void deleteOrder(BigDecimal id);
}
