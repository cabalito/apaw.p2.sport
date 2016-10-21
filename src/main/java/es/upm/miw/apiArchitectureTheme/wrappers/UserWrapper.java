package es.upm.miw.apiArchitectureTheme.wrappers;

public class UserWrapper {
	private String sportName;
	private int userValue;

	public UserWrapper() {
	}

	public UserWrapper(String sportName, int userValue) {
		this.sportName = sportName;
		this.userValue = userValue;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public int getUserValue() {
		return userValue;
	}

	public void setUserValue(int userValue) {
		this.userValue = userValue;
	}

	@Override
	public String toString() {
		return "{\"sportName\":\"" + sportName + ",\"userValue\":" + userValue + "}";
	}

}
