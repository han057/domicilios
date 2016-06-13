package com.hsofttecnologies.domicilios.config.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.hsofttecnologies.domicilios.config.HibernateConfig;
import com.hsofttecnologies.domicilios.config.MvcConfig;
import com.hsofttecnologies.domicilios.config.SecurityConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { HibernateConfig.class, SecurityConfig.class, MvcConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}

/*
 * implements WebApplicationInitializer { private Logger log =
 * Logger.getLogger(WebAppInitializer.class);
 * 
 * private static final Class<?>[] CONFIG_CLASSES = new Class<?>[] {
 * MvcConfig.class };
 * 
 * public void onStartup(ServletContext container) { log.info(
 * "Starting up the webapp..."); log.info(
 * "Creating root context for spring-web...");
 * AnnotationConfigWebApplicationContext rootContext = new
 * AnnotationConfigWebApplicationContext(); log.info("root context created!");
 * log.info("Registering config classes"); rootContext.register(CONFIG_CLASSES);
 * log.info("Config classes registered!");
 * 
 * 
 * // Create the dispatcher servlet's Spring application context
 * 
 * log.info("Registering spring-web dispatcher servlet...");
 * ServletRegistration.Dynamic dispatcher = container.addServlet( "dispatcher",
 * new DispatcherServlet(rootContext)); if (dispatcher == null) { log.error(
 * "Dispatcher null"); return; } dispatcher.setLoadOnStartup(1);
 * dispatcher.addMapping("/");
 * 
 * // Manage the lifecycle of the root application context
 * container.addListener(new ContextLoaderListener(rootContext)); }
 * 
 * }
 */