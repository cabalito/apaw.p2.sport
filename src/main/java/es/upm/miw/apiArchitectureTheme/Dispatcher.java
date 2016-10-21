package es.upm.miw.apiArchitectureTheme;

import es.upm.miw.apiArchitectureTheme.api.SportResource;
import es.upm.miw.apiArchitectureTheme.api.UserResource;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidRequestException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportFieldException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private SportResource themeResource = new SportResource();
	private UserResource voteResource = new UserResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/themes
		if ("themes".equals(request.getPath())) {
			response.setBody(themeResource.sportList().toString());
			// **/themes/{id}/overage
		} else if ("themes".equals(request.paths()[0]) && "overage".equals(request.paths()[2])) {
			try {
				response.setBody(themeResource.sportOverage(Integer.valueOf(request.paths()[1])).toString());
			} catch (Exception e) {
				responseError(response, e);
			}
			// **/votes
		} else if ("votes".equals(request.getPath())) {
			response.setBody(voteResource.userList().toString());
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// POST **/themes body="themeName"
		case "themes":
			// Injectar parámetros...
			try {
				themeResource.createSport(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (InvalidSportFieldException e) {
				this.responseError(response, e);
			}
			break;
		// POST votes body="themeId:vote"
		case "votes":
			String themeId = request.getBody().split(":")[0];
			String vote = request.getBody().split(":")[1];
			try {
				voteResource.createUser(Integer.valueOf(themeId), Integer.valueOf(vote));
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

}
