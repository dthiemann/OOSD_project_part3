package org.uiowa.cs2820.engine;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MyClient {
	public MyClient(String URI, String Path) {
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(URI);
		WebTarget resourceWebTarget = webTarget.path(Path);
		Invocation.Builder invocationBuilder = 
				resourceWebTarget.request(MediaType.TEXT_HTML);
		Response response = invocationBuilder.get();
		System.out.println(response.getStatus());
		System.out.println(response.readEntity(String.class));
	}

}
