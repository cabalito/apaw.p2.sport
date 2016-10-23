package es.upm.miw.apiArchitectureTheme;

import es.upm.miw.apiArchitectureTheme.api.SportResource;
import es.upm.miw.apiArchitectureTheme.api.UserResource;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidRequestException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidSportException;
import es.upm.miw.apiArchitectureTheme.exceptions.NotFoundSportNameException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private SportResource sportResource = new SportResource();
	private UserResource userResource = new UserResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		if (request.paths().length>1 &&
				("users".equals(request.paths()[0]) && "search".equals(request.paths()[1]))) {
			try {
                response.setBody(userResource.findUserBySportName(request.getParams().get("sport")).toString());
            } catch (Exception e) {
                responseError(response, e);
            }
		}
		else if (request.paths().length>0 && "users".equals(request.getPath())) {
			response.setBody(userResource.userList().toString());
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		case "sports":
			try {
				sportResource.createSport(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (NotFoundSportNameException | InvalidSportException e) {
				this.responseError(response, e);
			}
			break;
		case "users":
			String nick = request.getBody().split(":")[0];
			String email = request.getBody().split(":")[1];
			try {
				userResource.createUser(nick, email);
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
		if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {//comprobar nulos
			try {
				userResource.insertSport((request.paths()[1]), request.getBody());
				response.setStatus(HttpStatus.OK);
			} catch (Exception e) {
				responseError(response, e);
			}
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
