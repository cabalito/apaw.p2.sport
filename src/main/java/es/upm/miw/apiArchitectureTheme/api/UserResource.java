package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.UserController;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserException;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundSportIdException;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;

public class UserResource {

	// POST **/votes   body="themeId:vote"
	public void createUser(int userId, int user) throws InvalidUserException, NotFoundSportIdException {
		if (user < 0 || user > 10) {
			throw new InvalidUserException("" + user);
		}
		if (!new UserController().createUser(userId, user)) {
			throw new NotFoundSportIdException("" + userId);
		}
	}

	// GET **/votes
	public UserListWrapper userList() {
		return new UserController().userList();
	}

}
