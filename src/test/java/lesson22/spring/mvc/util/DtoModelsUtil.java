package lesson22.spring.mvc.util;

import java.math.BigDecimal;
import java.util.Date;

import lesson16.entry.Orders;
import lesson22.spring.mvc.dto.OrderDetails;
import lesson22.spring.mvc.dto.OrderRequest;

/**
 * @author spasko
 */
public class DtoModelsUtil {
	private static final int QTY = 12;
	private static final int AMOUNT = 15;
	private static final Date DATE = new Date(2021, 1, 1);
	private static final String MFR = "M12";

	public static Orders order() {
		Orders expected = new Orders();
		expected.setMfr(MFR);
		expected.setOrderDate(DATE);
		expected.setAmount(BigDecimal.valueOf(AMOUNT));
		expected.setQty(BigDecimal.valueOf(QTY));
		return expected;
	}

	public static OrderRequest orderRequest() {
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.setMfr(MFR);
		orderRequest.setOrderDate(DATE);
		orderRequest.setOrderDetails(orderDetails());
		return orderRequest;
	}

	public static OrderDetails orderDetails() {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setAmount(AMOUNT);
		orderDetails.setQty(QTY);
		return orderDetails;
	}
}
