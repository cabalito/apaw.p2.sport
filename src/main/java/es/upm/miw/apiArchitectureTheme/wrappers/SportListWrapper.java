package es.upm.miw.apiArchitectureTheme.wrappers;

import java.util.ArrayList;
import java.util.List;

public class SportListWrapper {
	List<SportWrapper> sportList;

	
	public SportListWrapper() {
		sportList = new ArrayList<>();
	}

	public List<SportWrapper> getSportList() {
		return sportList;
	}

	public void addSportWrapper(SportWrapper sportWrapper){
		sportList.add(sportWrapper);
	}
	

	@Override
	public String toString() {
		String result = "{\"sportList\":[ ";
		for (SportWrapper sportWrapper : sportList) {
			result += sportWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}
}
