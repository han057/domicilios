package com.hsofttecnologies.domicilios;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan({ "com.hsofttecnologies.domicilios.dao",
		"com.hsofttecnologies.domicilios.services" })
public class SpringContextTestConfig {

}
