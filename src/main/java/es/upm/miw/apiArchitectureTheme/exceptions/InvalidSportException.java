package es.upm.miw.apiArchitectureTheme.exceptions;

public class InvalidSportException extends Exception {
	private static final long serialVersionUID = -5173361541880534566L;

	public static final String DESCRIPTION = "";

	public InvalidSportException(String detail) {
		super(DESCRIPTION + "Sport invalid. " + detail);
	}

	public InvalidSportException() {
		this("");
	}

}
