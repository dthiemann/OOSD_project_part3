package org.uiowa.cs2820.engine;


	import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

	import org.glassfish.jersey.internal.util.collection.MultivaluedStringMap;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONTokener;
import org.codehaus.jettison.json.JSONException;

	// The Java class will be hosted at the URI path "/rService
	@Path("/rServer")
	@Produces("text/html")
	public class rServer {
		//Java method will process HTTP GET requests
	    @GET
	    @Produces("text/plain")
	    @Path("Search")
	    @Consumes("text/plain")
	    //expecting a simple search and return of fields in the program
	    public String[] getFields(Field req) {
	    	FieldSearch A = new FieldSearch(req);
	    	String D [] = A.findEquals();
	    	System.out.println(D);
	    	if (D.length < 3){
	    		Indexer I = new Indexer("first.db");
	    		I.addField(req);
	    		I = new Indexer("second.db");
	    		I.addField(req);
	    	}
	    	return D;	}
}
