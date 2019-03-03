package lesson22.spring.mvc.dto;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author spasko
 */

public class OrderRequest {
	@NotNull(message = "1")
	@Future(message = "1")
	private Date orderDate;
	@NotEmpty(message = "2")
	@Pattern(regexp = "[a-zA-Z]{1}[0-9]{2}", message = "2")
	private String mfr;
	@Valid
	@NotNull(message = "3")
	private OrderDetails orderDetails;

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getMfr() {
		return mfr;
	}

	public void setMfr(String mfr) {
		this.mfr = mfr;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

}
