package it.silph.silphportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	.antMatchers("/**")
	.permitAll()
	.antMatchers("/ModuliPage")
	.hasRole("FUNZIONARIO")
	.anyRequest()
	.authenticated()
	.and()
	.formLogin()
	.loginPage("/loginPage")
	.permitAll()
	.and()
	.logout()
	.permitAll();
    }
    
}