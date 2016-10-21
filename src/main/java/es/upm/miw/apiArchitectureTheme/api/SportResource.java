package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.SportController;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportFieldException;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundSportIdException;
import es.upm.miw.apiArchitectureTheme.wrappers.OverageWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.SportListWrapper;

public class SportResource {

	// GET **/themes
	public SportListWrapper sportList() {
		return new SportController().sportList();
	}

	// POST **/themes   body="themeName"
	public void createSport(String sportName) throws InvalidSportFieldException {
		this.validateField(sportName);
		new SportController().createSport(sportName);
	}

	private void validateField(String field) throws InvalidSportFieldException {
		if (field == null || field.isEmpty()) {
			throw new InvalidSportFieldException(field);
		}
	}

	// GET **themes/{id}/overage
	public OverageWrapper sportOverage(int sportId) throws NotFoundSportIdException {
		OverageWrapper overageWrapper = new SportController().sportOverage(sportId);
		if (overageWrapper == null) {
			throw new NotFoundSportIdException("" + sportId);
		} else {
			return overageWrapper;
		}
	}

}
