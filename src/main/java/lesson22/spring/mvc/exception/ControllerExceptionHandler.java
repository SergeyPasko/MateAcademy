package lesson22.spring.mvc.exception;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lesson21.springdata.exception.DeleteException;
import lesson22.spring.mvc.dto.ErrorMessage;

/**
 * @author spasko
 */
@ControllerAdvice
public class ControllerExceptionHandler {
	private static final Logger LOG = LogManager.getLogger(ControllerExceptionHandler.class);
	private static final Logger LOGMAIL = LogManager.getLogger("error-logger");

	private Map<String, String> validationCodeDescription = new HashMap<>();

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorMessage unexpected(Exception e) {
		LOGMAIL.error("Unexpected exception {}", e.getMessage());
		return new ErrorMessage(e.getMessage());
	}

	@ExceptionHandler(value = { DeleteException.class, UpdateException.class })
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public @ResponseBody ErrorMessage entityExistingProblem(Exception e) {
		LOG.warn("Unprocesable entity {}", e.getMessage());
		return new ErrorMessage(e.getMessage());
	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorMessage validationProblem(MethodArgumentNotValidException e) {
		LOG.warn("Request validation problem {}", e.getMessage());
		FieldError fe = e.getBindingResult().getFieldError();
		return new ErrorMessage(validationCodeDescription.get(fe.getDefaultMessage()));
	}

	@PostConstruct
	private void intValidationCodeDescription() {
		validationCodeDescription.put("1", "orderDate must be java.util.Date in future");
		validationCodeDescription.put("2", "mfr must have format one letters+two digitals");
		validationCodeDescription.put("3", "qty must be between 5..25");
		validationCodeDescription.put("4", "amount must bigger than 0");
	}
}
