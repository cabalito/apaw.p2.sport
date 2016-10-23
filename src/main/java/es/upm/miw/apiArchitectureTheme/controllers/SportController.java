package es.upm.miw.apiArchitectureTheme.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserException;
import es.upm.miw.apiArchitectureTheme.wrappers.OverageWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.SportListWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.SportWrapper;

public class SportController {

	public SportListWrapper sportList() {
		List<Sport> sportList = DaoFactory.getFactory().getSportDao().findAll();
		SportListWrapper sportListWrapper = new SportListWrapper();
		for (Sport sport : sportList) {
			sportListWrapper.addSportWrapper(new SportWrapper(sport.getId(), sport.getName()));
		}
		return sportListWrapper;
	}

	public void createSport(String sportName) throws InvalidSportException {
		if(DaoFactory.getFactory().getSportDao().findValueByName(sportName)!=null){
			throw new InvalidSportException(sportName);
		}
		DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
	}

	public SportWrapper findBySportName(String sportName) {
		List<Sport> sportList = DaoFactory.getFactory().getSportDao().findAll();
		for (Sport sport : sportList) {
			if(sportName.equals(sport.getName())){
				return new SportWrapper(sport.getId(), sport.getName());
			}
		}
		return null;
	}

}
