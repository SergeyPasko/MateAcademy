package lesson22.spring.mvc.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.hibernate.validator.HibernateValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import lesson22.spring.mvc.util.DtoModelsUtil;

/**
 * @author spasko
 */
public class OrderDetailsTest {
	private Validator validator;

	@Before
	public void setUp() {
		LocalValidatorFactoryBean localValidatorFactory = new LocalValidatorFactoryBean();
		localValidatorFactory.setProviderClass(HibernateValidator.class);
		localValidatorFactory.afterPropertiesSet();
		validator = localValidatorFactory;
	}

	@Test
	public void testOrderDetailsValid() {
		OrderDetails orderDetails = DtoModelsUtil.orderDetails();
		Errors errors = new BeanPropertyBindingResult(orderDetails, "orderDetails");
		validator.validate(orderDetails, errors);
		assertFalse(errors.hasErrors());
	}

	@Test
	public void testOrderDetailsQtyBiggerThanMax() {
		OrderDetails orderDetails = DtoModelsUtil.orderDetails();
		orderDetails.setQty(777);
		Errors errors = new BeanPropertyBindingResult(orderDetails, "orderDetails");
		validator.validate(orderDetails, errors);
		assertEquals(errors.getFieldError("qty").getDefaultMessage(), "3");
	}

	@Test
	public void testOrderDetailsQtyIsNull() {
		OrderDetails orderDetails = DtoModelsUtil.orderDetails();
		orderDetails.setQty(null);
		Errors errors = new BeanPropertyBindingResult(orderDetails, "orderDetails");
		validator.validate(orderDetails, errors);
		assertEquals(errors.getFieldError("qty").getDefaultMessage(), "3");
	}

	@Test
	public void testOrderDetailsAmountNegative() {
		OrderDetails orderDetails = DtoModelsUtil.orderDetails();
		orderDetails.setAmount(-11);
		Errors errors = new BeanPropertyBindingResult(orderDetails, "orderDetails");
		validator.validate(orderDetails, errors);
		assertEquals(errors.getFieldError("amount").getDefaultMessage(), "4");
	}

	@Test
	public void testOrderDetailsAmountIsNull() {
		OrderDetails orderDetails = DtoModelsUtil.orderDetails();
		orderDetails.setAmount(null);
		Errors errors = new BeanPropertyBindingResult(orderDetails, "orderDetails");
		validator.validate(orderDetails, errors);
		assertEquals(errors.getFieldError("amount").getDefaultMessage(), "4");
	}
}
