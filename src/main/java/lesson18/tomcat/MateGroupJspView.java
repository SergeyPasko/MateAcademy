package lesson18.tomcat;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.mvc.Viewable;

import lesson10.xmljson.MateGroup;

/**
 * @author spasko
 */

@Path("/")
public class MateGroupJspView {
	private MateGroup mateGroup = MateGroup.mateGroupExampleCreator();

	@GET
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public Viewable index(@QueryParam("groupId") String groupId) {

		if (groupId != null && groupId.equals("" + mateGroup.getId())) {
			return new Viewable("/index", mateGroup);
		}
		return new Viewable("/index");
	}
}
