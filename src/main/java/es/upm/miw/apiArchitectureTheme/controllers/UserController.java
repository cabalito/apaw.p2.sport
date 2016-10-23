package es.upm.miw.apiArchitectureTheme.controllers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidUserException;
import es.upm.miw.apiArchitectureTheme.wrappers.UserListWrapper;
import es.upm.miw.apiArchitectureTheme.wrappers.UserWrapper;

public class UserController {

	public void createUser(String nick, String email) throws InvalidUserException {
		if(DaoFactory.getFactory().getUserDao().findValueByNick(nick)!=null){
			throw new InvalidUserException(nick);
		}
		DaoFactory.getFactory().getUserDao().create(new User(nick, email));
	}
	
	public UserWrapper findByNick(String nick) {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		for (User user : userList) {
			if(user.getNick().contains(nick)){
				return new UserWrapper(user.getNick(), user.getEmail());
			}
		}
		return null;
	}


	public UserListWrapper userList() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
		}
		return userListWrapper;
	}

	public UserListWrapper findBySportName(String sportName) {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			if(user.getSports().toString().contains(sportName)){
				userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
			}
		}
		return userListWrapper;
	}
	
	public UserListWrapper findByAnySport() {
		List<User> userList = DaoFactory.getFactory().getUserDao().findAll();
		UserListWrapper userListWrapper = new UserListWrapper();
		for (User user : userList) {
			if(user.getSports()!=null){
				userListWrapper.addUserWrapper(new UserWrapper(user.getNick(), user.getEmail()));
			}
		}
		return userListWrapper;
	}
	
	public boolean insertSportInUser(String userName, String sportName) {
		User user = DaoFactory.getFactory().getUserDao().findValueByNick(userName);
		Sport sport = DaoFactory.getFactory().getSportDao().findValueByName(sportName);
		
		
		List<Sport> userSportList = user.getSports();
		if(!userSportList.contains(sportName)){
			userSportList.add(sport);
			user.setSports(userSportList);
			DaoFactory.getFactory().getUserDao().insertSport(user);
			return true;
		}else{
			return false;
		}
		
	}

}
