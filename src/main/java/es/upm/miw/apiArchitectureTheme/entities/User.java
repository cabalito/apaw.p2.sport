package es.upm.miw.apiArchitectureTheme.entities;

public class User {

    private int id;

    private int value;

    private Sport sport;

    public User() {
    }

    public User(int value, Sport sport) {
        this.value = value;
        this.sport = sport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
        return value;
    }

    public Sport getUser() {
        return sport;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", value=" + value + ", sport=" + sport + "]";
	}

}
