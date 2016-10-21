package es.upm.miw.apiArchitectureTheme.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
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

	public void createSport(String sportName) {
		DaoFactory.getFactory().getSportDao().create(new Sport(sportName));
	}

	public OverageWrapper sportOverage(int sportId) {
		if (DaoFactory.getFactory().getSportDao().read(sportId) == null) {
			return null;
		}
		List<Integer> userValues = DaoFactory.getFactory().getUserDao().findValueByUserId(sportId);
		double total = 0;
		for (Integer value : userValues) {
			total += value;
		}
		return new OverageWrapper(total / userValues.size());
	}

}
