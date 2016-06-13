package com.hsofttecnologies.domicilios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.formLogin()
			.and()
		.csrf()
			.disable()
		.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/pedido/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/producto/categoria/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/imagen/**").permitAll()
			.antMatchers("/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_ADMIN_PEDIDOS')")
			.anyRequest().authenticated();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder(12);
		return encoder;
	}
}