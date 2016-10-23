package es.upm.miw.apiArchitectureTheme.api;

import es.upm.miw.apiArchitectureTheme.controllers.SportController;
import es.upm.miw.apiArchitectureTheme.controllers.UserController;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserException;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundSportNameException;
import es.upm.miw.apiArchitectureTheme.wrappers.SportWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;

public class UserResource {

	public void createUser(String nick, String email) throws InvalidUserException {
		if (nick ==null || email == null  || !email.contains("@")) {
			throw new InvalidUserException("Email format not valid ");
		}
		new UserController().createUser(nick, email);
	}

	public UserListWrapper userList() {
		return new UserController().userList();
	}

	public UserListWrapper findUserBySportName(String sportName) throws NotFoundSportNameException {
		if(sportName.equals("*")){
			return new UserController().findByAnySport();
		}else if (new SportController().sportList().getSportList().toString().contains(sportName)) {
            return new UserController().findBySportName(sportName);
        } else {
            throw new NotFoundSportNameException(sportName);
        }
	}
	
	public void insertSport(String nickName, String sportName) throws  NotFoundSportNameException{
		if (!new SportController().sportList().getSportList().toString().contains(sportName)){
			throw new NotFoundSportNameException(sportName);
		}
		
		if(!new UserController().insertSportInUser(nickName, sportName)){
			
		}
		
	}
	
}
