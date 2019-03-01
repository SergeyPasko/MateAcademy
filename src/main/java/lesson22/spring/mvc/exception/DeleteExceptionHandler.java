package lesson22.spring.mvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lesson22.spring.mvc.dto.ErrorMessage;

import org.springframework.http.HttpStatus;

/**
 * @author spasko
 */
@ControllerAdvice
public class DeleteExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorMessage getOrderById(Exception e) {
		return new ErrorMessage(e.getMessage());
	}
}
