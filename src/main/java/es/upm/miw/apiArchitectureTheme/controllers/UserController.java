package es.upm.miw.apiArchitectureTheme.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.UserWrapper;

public class UserController {

	public boolean createUser(int userId, int user) {
		Sport sport = DaoFactory.getFactory().getSportDao().read(userId);
		if (sport != null) {
			DaoFactory.getFactory().getUserDao().create(new User(user, sport));
			return true;
		} else {
			return false;
		}
	}

	public UserListWrapper userList() {
		List<User> users = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : users) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getUser().getName(),user.getValue()));
		}
		return userListWrapper;
	}

}
