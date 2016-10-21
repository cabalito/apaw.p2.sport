package es.upm.miw.apiArchitectureTheme.entities;

import java.util.Calendar;

public class Sport {

    private int id;

    private String name;
    
    private Calendar date;

    public Sport() {
    }

    public Sport(String name) {
        this.name = name;
        this.date = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

	public Calendar getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

}
