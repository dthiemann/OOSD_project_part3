package org.uiowa.cs2820.engine;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
	    	if (D.length < 3){
	    		Indexer I = new Indexer("first.db");
	    		I.addField(req);
	    		I = new Indexer("second.db");
	    		I.addField(req);
	    	}
	    	for (String elements : D) {
	    		System.out.println(elements);
	    		}
	    	return D;	
	    }
}
