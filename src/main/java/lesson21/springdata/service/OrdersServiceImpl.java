package lesson21.springdata.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lesson21.springdata.entity.Orders;
import lesson21.springdata.repository.OrdersRepository;

/**
 * @author spasko
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Set<Orders> getAllOrders() {
		return new HashSet<>(ordersRepository.findAll());
	}

	@Override
	public Orders findOrderById(BigDecimal id) {
		return ordersRepository.findById(id).get();
	}

	@Override
	public void insertOrder(Orders order) {
		ordersRepository.save(order);
	}

	@Override
	public void updateOrder(Orders order) {
		ordersRepository.save(order);
	}

	@Override
	public void deleteOrder(BigDecimal id) {
		ordersRepository.deleteById(id);
	}

	@Override
	public Set<Orders> findByQtyBetween(int minQty, int maxQty) {
		return new HashSet<>(ordersRepository.findByQtyBetween(BigDecimal.valueOf(minQty), BigDecimal.valueOf(maxQty)));
	}

}
