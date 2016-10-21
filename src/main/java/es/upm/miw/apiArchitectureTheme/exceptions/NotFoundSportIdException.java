package es.upm.miw.apiArchitectureTheme.exceptions;

public class NotFoundSportIdException extends Exception {
	private static final long serialVersionUID = -3893110892899234744L;
	
	public static final String DESCRIPTION = "El id del deporte no existe";

	public NotFoundSportIdException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

	public NotFoundSportIdException() {
		this("");
	}
}
