package lesson21.springdata.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import lesson16.entry.Orders;
import lesson21.springdata.repository.OrdersRepository;

/**
 * @author spasko
 */
@RunWith(MockitoJUnitRunner.class)
public class OrdersServiceImplTest {
	@Spy
	@InjectMocks
	private OrdersService ordersService = new OrdersServiceImpl();
	@Mock
	private OrdersRepository ordersRepository;

	private Orders order1 = new Orders();
	private Orders order2 = new Orders();

	@Test
	public void testGetAllOrders() {
		List<Orders> orders = Arrays.asList(new Orders[] { order1, order2 });
		doReturn(orders).when(ordersRepository).findAll();
		Set<Orders> result = ordersService.getAllOrders();
		assertTrue(orders.containsAll(result) && result.containsAll(orders));
	}

	@Test
	public void testFindOrderById() {
		doReturn(Optional.of(order1)).when(ordersRepository).findById(any());
		Orders result = ordersService.findOrderById(BigDecimal.TEN);
		assertEquals(order1, result);
	}

	@Test
	public void testFindByQtyBetween() {
		List<Orders> orders = Arrays.asList(new Orders[] { order1, order2 });
		doReturn(orders).when(ordersRepository).findByQtyBetween(any(), any());
		Set<Orders> result = ordersService.findByQtyBetween(0, 0);
		assertTrue(orders.containsAll(result) && result.containsAll(orders));
	}

	@Test
	public void testInsertOrder() {
		doReturn(order1).when(ordersRepository).save(any());
		ordersService.insertOrder(order1);
		verify(ordersRepository, times(1)).save(any());
	}

	@Test
	public void testUpdateOrder() {
		doReturn(order1).when(ordersRepository).save(any());
		ordersService.updateOrder(order1);
		verify(ordersRepository, times(1)).save(any());
	}

	@Test
	public void testDeleteOrder() {
		doNothing().when(ordersRepository).deleteById(any());
		ordersService.deleteOrder(order1.getOrderNum());
		verify(ordersRepository, times(1)).deleteById(any());
	}
}
