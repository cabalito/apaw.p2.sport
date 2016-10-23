package es.upm.miw.apiArchitectureTheme.wrappers;

import java.util.List;

import es.upm.miw.apiArchitectureTheme.entities.Sport;

public class UserWrapper {
	private String nick;
	private String email;
	private List<Sport> sports;

	public UserWrapper() {
	}

	public UserWrapper(String nick, String email) {
		this.nick = nick;
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
		return "{\"nick\":\"" + nick + ",\"email\":" + email + "}";
	}

}
