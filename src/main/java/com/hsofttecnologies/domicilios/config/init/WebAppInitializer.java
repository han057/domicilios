package com.hsofttecnologies.domicilios.config.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.hsofttecnologies.domicilios.config.MvcConfig;

public class WebAppInitializer implements WebApplicationInitializer {
	private Logger log = Logger.getLogger(WebAppInitializer.class);

	private static final Class<?>[] CONFIG_CLASSES = new Class<?>[] { MvcConfig.class };

	public void onStartup(ServletContext container) {
		log.info("Starting up the webapp...");
		log.info("Creating root context for spring-web...");
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		log.info("root context created!");
		log.info("Registering config classes");
		rootContext.register(CONFIG_CLASSES);
		log.info("Config classes registered!");
		

		// Create the dispatcher servlet's Spring application context
		/*AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(CONFIG_CLASSES);*/

		log.info("Registering spring-web dispatcher servlet...");
		ServletRegistration.Dynamic dispatcher = container.addServlet(
				"dispatcher", new DispatcherServlet(rootContext));
		if (dispatcher == null) {
			log.error("Dispatcher null");
			return;
		}
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

		// Manage the lifecycle of the root application context
		container.addListener(new ContextLoaderListener(rootContext));
	}

}
