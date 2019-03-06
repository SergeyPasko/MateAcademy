package lesson22.spring.mvc.exception;

/**
 * @author spasko
 */
public class UpdateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UpdateException(String message) {
		super(message);
	}
}
