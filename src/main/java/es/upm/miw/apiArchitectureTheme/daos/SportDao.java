package es.upm.miw.apiArchitectureTheme.daos;

import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;

public interface SportDao extends GenericDao<Sport, Integer> {
	Sport findValueByName(String sportName);
}
