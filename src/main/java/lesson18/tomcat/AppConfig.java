package lesson18.tomcat;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;

/**
 * @author spasko
 */
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		packages("lesson18.tomcat");
		property(JspMvcFeature.TEMPLATE_BASE_PATH, "/WEB-INF/jsp");
		register(JspMvcFeature.class);
	}
}
