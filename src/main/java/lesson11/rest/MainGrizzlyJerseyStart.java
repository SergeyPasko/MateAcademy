package lesson11.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * @author spasko
 */
public class MainGrizzlyJerseyStart {
	public static void main(String[] args) throws IOException, URISyntaxException {
		final String baseUri = "http://localhost:9998/";

		System.out.println("Starting grizzly...");
		final ResourceConfig rc = new ResourceConfig().packages("lesson11.rest");

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		GrizzlyHttpServerFactory.createHttpServer(new URI(baseUri), rc);
		System.out
				.println(String.format("Jersey started with WADL available at %sapplication.wadl.", baseUri, baseUri));
	}
}
