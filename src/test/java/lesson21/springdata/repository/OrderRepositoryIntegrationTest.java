package lesson21.springdata.repository;
/**
 * @author spasko
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lesson16.entry.Orders;
import lesson21.springdata.config.DataConfig;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@Transactional
@Rollback
public class OrderRepositoryIntegrationTest {
	private static final BigDecimal NOT_EXIST_ORDER = BigDecimal.valueOf(-1);
	private static final BigDecimal ALREADY_EXIST_ORDER = BigDecimal.valueOf(112979);
	private static final Orders ORDER = new Orders(BigDecimal.valueOf(12345), null, null, null, new Date(), null,
			BigDecimal.valueOf(-1), null);
	@Autowired
	private OrdersRepository ordersRepository;

	@Test
	public void testGetAllOrders() {
		List<Orders> orders = ordersRepository.findAll();
		System.out.println(orders);
		assertTrue(orders.size() > 15);
	}

	@Test
	public void testInsertOrder() {
		ordersRepository.save(ORDER);
	}

	@Test
	public void testUpdateOrder() {
		Orders order = ordersRepository.findById(ALREADY_EXIST_ORDER).get();

		order.setAmount(BigDecimal.valueOf(-333));
		order.setQty(BigDecimal.valueOf(-111));
		ordersRepository.save(order);
	}

	@Test
	public void testDeleteOrder() {
		Orders order = ordersRepository.findById(ALREADY_EXIST_ORDER).get();
		ordersRepository.delete(order);
	}

	@Test
	public void testFindOrderByIdNotPresent() {
		Optional<Orders> order = ordersRepository.findById(NOT_EXIST_ORDER);
		assertFalse(order.isPresent());
	}

	@Test
	public void testFindOrderById() {
		Optional<Orders> order = ordersRepository.findById(ALREADY_EXIST_ORDER);
		assertTrue(order.isPresent());
	}

	@Test
	public void testFindByQtyBetweenindOrderById() {
		List<Orders> orders = ordersRepository.findByQtyBetween(BigDecimal.valueOf(5), BigDecimal.valueOf(15));
		assertTrue(orders.size() > 5);
	}

}
