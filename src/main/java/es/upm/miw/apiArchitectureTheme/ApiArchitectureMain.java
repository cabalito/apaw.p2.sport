package es.upm.miw.apiArchitectureTheme;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.daos.memory.DaoFactoryMemory;
import es.upm.miw.web.http.HttpMethod;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import upm.jbb.IO;

public class ApiArchitectureMain {

	private Server server = new Server();

	private HttpRequest request = new HttpRequest();

	public void help() {
		IO.getIO().println("GET **/themes");
		IO.getIO().println("POST **/themes   body=\"themeName\"");
		IO.getIO().println("GET **/themes/{id}/overage");
		IO.getIO().println("POST **/votes   body=\"themeId:vote\"");
		IO.getIO().println("GET **/votes");
	}

	public void demo() {
		request.setMethod(HttpMethod.POST);
		request.setPath("themes");
		request.setBody("uno");
		this.request();
		request.setBody("dos");
		this.request();
		request.setPath("votes");
		request.setBody("1:4");
		this.request();
		request.setBody("1:5");
		this.request();
		request.setBody("2:5");
		this.request();
		request.setBody("2:6");
		this.request();
		request.setMethod(HttpMethod.GET);
		request.setPath("votes");
		request.clearQueryParams();
		request.setBody("");
		this.request();
		request.setPath("themes");
		this.request();
		request.setPath("themes/1/overage");
		this.request();
		request.setPath("themes/2/overage");
		this.request();
		//Exceptions
		request.setPath("noValid");
		this.request();
		request.setPath("themes/x/overage");
		this.request();
		request.setPath("themes/99/overage");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("votes");
		request.setBody("99:4");
		this.request();
	}

	public void httpMethod() {
		request.setMethod((HttpMethod) IO.getIO().select(HttpMethod.values(), "Elige método"));
		this.showStatus();
	}

	public void path() {
		request.setPath(IO.getIO().readString("Path"));
		this.showStatus();
	}

	public void addQueryParam() {
		String[] msgs = { "Nombre", "Valor" };
		String[] campos = { "String", "String" };
		Object[] values = IO.getIO().readForm(campos, msgs);
		request.addQueryParam((String) values[0], (String) values[1]);
		this.showStatus();
	}

	public void clearQueryParams() {
		request.clearQueryParams();
		this.showStatus();
	}

	private void showStatus() {
		IO.getIO().setStatusBar(request.toString());
	}

	public void request() {
		IO.getIO().println(request.toString());
		HttpResponse response = server.request(request);
		IO.getIO().println(response);
		IO.getIO().println("---------------------------------------ooo----------------------------------------");
	}

	public static void main(String[] args) {
		ApiArchitectureMain main = new ApiArchitectureMain();
		IO.getIO().addView(main);
		main.showStatus();
		DaoFactory.setFactory(new DaoFactoryMemory());
	}
}
