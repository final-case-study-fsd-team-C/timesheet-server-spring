package com.myapp.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
JwtWebSecurityConfigurer
.forRS256(apiAudience, issuer)
.configure(http)
.authorizeRequests()
.antMatchers(HttpMethod.GET, "/api/projects").hasAuthority("view:registrations")
.antMatchers(HttpMethod.GET, "/api/timesheet").hasAuthority("view:registrations")
.antMatchers(HttpMethod.GET, "/api/phases/**").hasAuthority("view:registration")
.antMatchers(HttpMethod.GET, "/api/clients/**").hasAuthority("view:registration")
.anyRequest().authenticated();
}


}