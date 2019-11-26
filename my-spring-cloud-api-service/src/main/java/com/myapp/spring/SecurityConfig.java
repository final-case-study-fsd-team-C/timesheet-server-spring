package com.myapp.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Value(value = "${auth0.apiAudience}")
private String apiAudience;
@Value(value = "${auth0.issuer}")
private String issuer;

@Override
protected void configure(HttpSecurity http) throws Exception {
	
	
	http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
JwtWebSecurityConfigurer
.forRS256(apiAudience, issuer)

.configure(http)
.authorizeRequests()
.antMatchers(HttpMethod.GET, "/api/timesheet").hasAuthority("view:registrations")
.antMatchers(HttpMethod.GET, "/api/projects").hasAuthority("view:registrations")
.antMatchers(HttpMethod.GET, "/api/clients").hasAuthority("view:registrations")
.antMatchers(HttpMethod.GET, "/api/phases").hasAuthority("view:registrations")
.antMatchers(HttpMethod.GET, "/api/timesheet/**").hasAuthority("view:registration")
.antMatchers(HttpMethod.GET, "/api/projects/**").hasAuthority("view:registration")
.antMatchers(HttpMethod.GET, "/api/clients/**").hasAuthority("view:registration")
.antMatchers(HttpMethod.GET, "/api/phases/**").hasAuthority("view:registration")
.antMatchers(HttpMethod.POST, "/api/timesheet").hasAuthority("view:registrations")
.antMatchers(HttpMethod.POST, "/api/projects").hasAuthority("view:registrations")
.antMatchers(HttpMethod.POST, "/api/clients").hasAuthority("view:registrations")
.antMatchers(HttpMethod.POST, "/api/phases").hasAuthority("view:registrations")
.antMatchers(HttpMethod.PUT, "/api/timesheet/**").hasAuthority("view:registrations")
.antMatchers(HttpMethod.PUT, "/api/projects/**").hasAuthority("view:registrations")
.antMatchers(HttpMethod.PUT, "/api/clients/**").hasAuthority("view:registrations")
.antMatchers(HttpMethod.PUT, "/api/phases/**").hasAuthority("view:registrations")
.antMatchers(HttpMethod.DELETE, "/api/timesheet/**").hasAuthority("view:registrations")
.antMatchers(HttpMethod.DELETE, "/api/projects/**").hasAuthority("view:registrations")
.antMatchers(HttpMethod.DELETE, "/api/clients/**").hasAuthority("view:registrations")
.antMatchers(HttpMethod.DELETE, "/api/phases/**").hasAuthority("view:registrations")
.anyRequest().authenticated();
}


}