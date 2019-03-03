package lesson22.spring.mvc.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author spasko
 */
public class OrderDetails {
	@Min(value = 5, message = "3")
	@Max(value = 25, message = "3")
	@NotNull(message = "3")
	private Integer qty;
	@NotNull(message = "4")
	@Min(value = 1, message = "4")
	private Integer amount;

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
