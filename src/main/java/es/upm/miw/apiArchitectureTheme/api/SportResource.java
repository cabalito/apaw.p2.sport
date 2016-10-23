package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.SportController;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportException;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundSportNameException;
import es.upm.miw.apiArchitectureTheme.wrappers.SportListWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.SportWrapper;

public class SportResource {

	public SportListWrapper sportList() {
		return new SportController().sportList();
	}

	public void createSport(String sportName) throws NotFoundSportNameException, InvalidSportException {
		this.validateField(sportName);
		new SportController().createSport(sportName);
	}

	private void validateField(String field) throws NotFoundSportNameException {
		if (field == null || field.isEmpty()) {
			throw new NotFoundSportNameException(field);
		}
	}

	public SportWrapper findBySportName(String sportName) throws NotFoundSportNameException {
		 if (new SportController().sportList().getSportList().toString().contains(sportName)) {
            return new SportController().findBySportName(sportName);
        } else {
            throw new NotFoundSportNameException(sportName);
        }
	}

}
