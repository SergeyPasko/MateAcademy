package lesson22.spring.mvc.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

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
public class OrderRequestTest {
	private Validator validator;

	@Before
	public void setUp() {
		LocalValidatorFactoryBean localValidatorFactory = new LocalValidatorFactoryBean();
		localValidatorFactory.setProviderClass(HibernateValidator.class);
		localValidatorFactory.afterPropertiesSet();
		validator = localValidatorFactory;
	}

	@Test
	public void testOrderRequestValid() {
		OrderRequest orderRequest = DtoModelsUtil.orderRequest();
		Errors errors = new BeanPropertyBindingResult(orderRequest, "orderRequest");
		validator.validate(orderRequest, errors);
		assertFalse(errors.hasErrors());
	}

	@Test
	public void testOrderRequestMfrWrongFormat() {
		OrderRequest orderRequest = DtoModelsUtil.orderRequest();
		orderRequest.setMfr("Wrong format");
		Errors errors = new BeanPropertyBindingResult(orderRequest, "orderRequest");
		validator.validate(orderRequest, errors);
		assertEquals(errors.getFieldError("mfr").getDefaultMessage(), "2");
	}

	@Test
	public void testOrderRequestMfrIsNull() {
		OrderRequest orderRequest = DtoModelsUtil.orderRequest();
		orderRequest.setMfr(null);
		Errors errors = new BeanPropertyBindingResult(orderRequest, "orderRequest");
		validator.validate(orderRequest, errors);
		assertEquals(errors.getFieldError("mfr").getDefaultMessage(), "2");
	}

	@Test
	public void testOrderRequestDateInPast() {
		OrderRequest orderRequest = DtoModelsUtil.orderRequest();
		orderRequest.setOrderDate(Date.from(LocalDate.of(1990, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		Errors errors = new BeanPropertyBindingResult(orderRequest, "orderRequest");
		validator.validate(orderRequest, errors);
		assertEquals(errors.getFieldError("orderDate").getDefaultMessage(), "1");
	}

	@Test
	public void testOrderRequestDateIsNull() {
		OrderRequest orderRequest = DtoModelsUtil.orderRequest();
		orderRequest.setOrderDate(null);
		Errors errors = new BeanPropertyBindingResult(orderRequest, "orderRequest");
		validator.validate(orderRequest, errors);
		assertEquals(errors.getFieldError("orderDate").getDefaultMessage(), "1");
	}

	@Test
	public void testOrderRequestOrderDetailsIsNull() {
		OrderRequest orderRequest = DtoModelsUtil.orderRequest();
		orderRequest.setOrderDetails(null);
		Errors errors = new BeanPropertyBindingResult(orderRequest, "orderRequest");
		validator.validate(orderRequest, errors);
		assertEquals(errors.getFieldError("orderDetails").getDefaultMessage(), "3");
	}
}
