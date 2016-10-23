package es.upm.miw.apiArchitectureTheme.daos.memory;

import java.util.HashMap;
import java.util.List;

import es.upm.miw.apiArchitectureTheme.daos.UserDao;
import es.upm.miw.apiArchitectureTheme.entities.Sport;
import es.upm.miw.apiArchitectureTheme.entities.User;

public class UserDaoMemory extends GenericMemoryDao<User> implements UserDao {

	public UserDaoMemory() {
		this.setMap(new HashMap<Integer,User>());
	}

	@Override
	protected Integer getId(User entity) {
		return entity.getId();
	}

	@Override
	protected void setId(User entity, Integer id) {
		entity.setId(id);
	}

	@Override
	public User findValueByNick(String nick) {
		List<User> userList = this.findAll();
		for (User user : userList) {
			if (user.getNick().equals(nick)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public void insertSport(User user) {
		this.update(user);
	}

}