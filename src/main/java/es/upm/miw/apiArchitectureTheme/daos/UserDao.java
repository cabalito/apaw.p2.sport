package es.upm.miw.apiArchitectureTheme.daos;

import es.upm.miw.apiArchitectureTheme.entities.User;
import es.upm.miw.apiArchitectureTheme.wrappers.UserWrapper;

public interface UserDao extends GenericDao<User, Integer> {
	User findValueByNick(String nick);
	
	void insertSport(User user);
}
