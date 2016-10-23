package es.upm.miw.apiArchitectureTheme.exceptions;

public class NotFoundSportNameException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "SportName not found :";

	public NotFoundSportNameException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public NotFoundSportNameException() {
		this("");
	}
}
