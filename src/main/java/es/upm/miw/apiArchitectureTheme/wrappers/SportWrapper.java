package es.upm.miw.apiArchitectureTheme.wrappers;

public class SportWrapper {
	private int id;
	private String name;

	public SportWrapper() {
	}

	public SportWrapper(int id, String name) {
		this.setId(id);
		this.setName(name);
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

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ",\"name\":\"" + name + "\"}";
	}

}
