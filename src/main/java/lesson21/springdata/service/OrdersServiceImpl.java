package lesson21.springdata.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import lesson16.entry.Orders;
import lesson21.springdata.exception.DeleteException;
import lesson21.springdata.repository.OrdersRepository;

/**
 * @author spasko
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
	private static final Logger LOG = LogManager.getLogger(OrdersServiceImpl.class);

	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Set<Orders> getAllOrders() {
		LOG.debug("getAllOrders");
		HashSet<Orders> result = new HashSet<>(ordersRepository.findAll());
		LOG.debug("getAllOrders return {} records", result.size());
		return result;
	}

	@Override
	public Orders findOrderById(BigDecimal id) {
		LOG.debug("findOrderById, id={}", id);
		Orders result = ordersRepository.findById(id).orElse(null);
		LOG.debug("findOrderById, result={}", result);
		return result;
	}

	@Override
	public void insertOrder(Orders order) {
		LOG.debug("insertOrder, order={}", order);
		ordersRepository.save(order);
		LOG.debug("insertOrder completed");
	}

	@Override
	public void updateOrder(Orders order) {
		LOG.debug("updateOrder, order={}", order);
		ordersRepository.save(order);
		LOG.debug("updateOrder completed");
	}

	@Override
	public void deleteOrder(BigDecimal id) {
		LOG.debug("deleteOrder, id={}", id);
		try {
			ordersRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			LOG.warn("Cannot deleteOrder with id{}, becouse dont present", id);
			throw new DeleteException("Cannot delete Order by Id=" + id + ", because it dont present");
		}
		LOG.debug("deleteOrder completed");
	}

	@Override
	public Set<Orders> findByQtyBetween(int minQty, int maxQty) {
		LOG.debug("findByQtyBetween, min={}, max={}", minQty, maxQty);
		HashSet<Orders> result = new HashSet<>(
				ordersRepository.findByQtyBetween(BigDecimal.valueOf(minQty), BigDecimal.valueOf(maxQty)));
		LOG.debug("findByQtyBetween, result={}", result);
		return result;
	}

}
