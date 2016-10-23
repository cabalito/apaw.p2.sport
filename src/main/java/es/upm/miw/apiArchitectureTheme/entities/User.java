package es.upm.miw.apiArchitectureTheme.entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;

    private String nick;

    private String email;
    
    private List<Sport> sports;

    public User() {
    }

    public User(String nick, String email) {
        this.nick = nick;
        this.email = email;
        this.sports = new ArrayList<Sport>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public String getEmail() {
		return email;
	}

	public void setNick(String nick) {
		this.nick = nick;
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
		return "User [id=" + id + ", nick=" + nick + ", email=" + email + "]";
	}

}
