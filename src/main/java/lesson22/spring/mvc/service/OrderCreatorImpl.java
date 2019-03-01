package lesson22.spring.mvc.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import lesson16.entry.Orders;
import lesson22.spring.mvc.dto.OrderDetails;
import lesson22.spring.mvc.dto.OrderRequest;

/**
 * @author spasko
 */
@Service
public class OrderCreatorImpl implements OrderCreator {

	@Override
	public Orders createOrder(OrderRequest orderRequest) {
		Orders result = new Orders();
		result.setOrderDate(orderRequest.getOrderDate());
		result.setMfr(orderRequest.getMfr());

		OrderDetails orderDetails = orderRequest.getOrderDetails();
		result.setQty(BigDecimal.valueOf(orderDetails.getQty()));
		result.setAmount(BigDecimal.valueOf(orderDetails.getAmount()));
		return result;
	}

}
