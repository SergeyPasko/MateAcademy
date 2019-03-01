package lesson22.spring.mvc.service;
/**
 * @author spasko
 */

import lesson16.entry.Orders;
import lesson22.spring.mvc.dto.OrderRequest;

public interface OrderCreator {
	Orders createOrder(OrderRequest orderRequest);
}
