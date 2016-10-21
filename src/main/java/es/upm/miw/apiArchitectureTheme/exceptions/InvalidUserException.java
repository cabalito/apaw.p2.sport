package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidUserException extends Exception {
	private static final long serialVersionUID = -5173361541880534566L;

	public static final String DESCRIPTION = "Usuario no encontrado";

	public InvalidUserException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public InvalidUserException() {
		this("");
	}

}
