package lesson22.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lesson23.spring.security.config.SpringSecurityConfig;

/**
 * @author spasko
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringSecurityConfig.class };
		// return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { MainMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
