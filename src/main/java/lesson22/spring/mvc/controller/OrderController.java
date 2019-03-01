package lesson22.spring.mvc.controller;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lesson16.entry.Orders;
import lesson21.springdata.service.OrdersService;
import lesson22.spring.mvc.dto.OrderRequest;
import lesson22.spring.mvc.service.OrderCreator;

/**
 * @author spasko
 */

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private OrderCreator orderCreator;

	@GetMapping
	public @ResponseBody Set<Orders> getOrdersQtyBetween(@RequestParam(value = "min", required = false) Integer minQty,
			@RequestParam(value = "max", required = false) Integer maxQty) {
		if (Objects.isNull(maxQty) || Objects.isNull(minQty)) {
			return ordersService.getAllOrders();
		}
		return ordersService.findByQtyBetween(minQty, maxQty);
	}

	@PostMapping
	public void addOrder(@Valid OrderRequest orderRequest) {
		Orders order = orderCreator.createOrder(orderRequest);
		ordersService.insertOrder(order);
	}

	@GetMapping("/{id}")
	public @ResponseBody Orders getOrderById(@PathVariable("id") int id) {
		return ordersService.findOrderById(BigDecimal.valueOf(id));
	}

	@DeleteMapping("/{id}")
	public void deleteOrderById(@PathVariable("id") int id) {
		try {
			ordersService.deleteOrder(BigDecimal.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PutMapping("/{id}")
	public void updateOrderById(@PathVariable("id") int id, @RequestParam("qty") Integer qty) {
		Orders order = ordersService.findOrderById(BigDecimal.valueOf(id));
		if (Objects.isNull(order)) {
			// throw new RuntimeException();
		} else {
			order.setQty(BigDecimal.valueOf(qty));
			ordersService.updateOrder(order);
		}
	}

}
