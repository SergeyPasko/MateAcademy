package lesson21.springdata.exception;

/**
 * @author spasko
 */
public class DeleteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DeleteException(String message) {
		super(message);
	}
}
