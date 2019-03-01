package lesson21.springdata.repository;
/**
 * @author spasko
 */

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lesson16.entry.Orders;
import lesson21.springdata.config.DataConfig;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataConfig.class)
@TestPropertySource("classpath:lesson21/test.properties")
public class OrderRepositoryIntegrationH2Test {
	private static final Orders NOT_EXIST_ORDER_INSERT = new Orders(BigDecimal.valueOf(333333));
	private static final Orders ALREADY_EXIST_ORDER_UPDATE = new Orders(BigDecimal.valueOf(111111));
	private static final Orders ALREADY_EXIST_ORDER_DELETE = new Orders(BigDecimal.valueOf(222222));
	private static final BigDecimal NOT_EXIST_ORDER_ID = BigDecimal.valueOf(-1);

	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private DataSource dataSource;

	@Before
	public void initDb() {
		Resource initSchema = new ClassPathResource("lesson21\\script\\schema.sql");
		Resource data = new ClassPathResource("lesson21\\script\\data.sql");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, data);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
	}

	@Test
	public void testGetAllOrders() {
		List<Orders> orders = ordersRepository.findAll();
		System.out.println(orders);
		assertTrue(orders.size() >= 2);
	}

	@Test
	public void testInsertOrder() {
		ordersRepository.save(NOT_EXIST_ORDER_INSERT);
	}

	@Test
	public void testUpdateOrder() {
		ALREADY_EXIST_ORDER_UPDATE.setAmount(BigDecimal.valueOf(-333));
		ALREADY_EXIST_ORDER_UPDATE.setQty(BigDecimal.valueOf(-111));
		ordersRepository.save(ALREADY_EXIST_ORDER_UPDATE);
	}

	@Test
	public void testDeleteOrder() {
		ordersRepository.delete(ALREADY_EXIST_ORDER_DELETE);
	}

	@Test
	public void testFindOrderByIdNotPresent() {
		Optional<Orders> order = ordersRepository.findById(NOT_EXIST_ORDER_ID);
		assertFalse(order.isPresent());
	}

	@Test
	public void testFindOrderById() {
		Optional<Orders> order = ordersRepository.findById(ALREADY_EXIST_ORDER_UPDATE.getOrderNum());
		assertTrue(order.isPresent());
	}

	@Test
	public void testFindByQtyBetweenindOrderById() {
		List<Orders> orders = ordersRepository.findByQtyBetween(BigDecimal.valueOf(5), BigDecimal.valueOf(15));
		assertTrue(orders.size() == 1);
	}

}
