package es.upm.miw.apiArchitectureTheme.daos;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.entities.User;

public interface UserDao extends GenericDao<User, Integer> {
	List<Integer> findValueByUserId(int sportId);
}
