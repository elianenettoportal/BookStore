package com.hbsis.bookstore.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


     @Override
     protected void configure(HttpSecurity http) throws Exception {
         // disable caching
    	 http.headers().cacheControl();
         
    	 /*ROUTING SECURITY*/
         http.csrf().disable() // disable csrf for our requests.
         	 .cors().and()
             .authorizeRequests()
             .antMatchers("/", "/index").permitAll()
            // .antMatchers("/").permitAll()
             
             //shows
             .antMatchers( "/api/v1/books/**" ).hasAnyAuthority("USERS_LIST,USERS_CREATE,USERS_EDIT,USERS_DELETE")
             
                          
             //login 
             .antMatchers(HttpMethod.POST, "/api/v1/login").permitAll()
             //landinpage
             .antMatchers(HttpMethod.GET, "/api/v1/landinpage").permitAll()
             
            // .anyRequest().authenticated()
             .anyRequest().permitAll();
             //.and()
             // We filter the api/login requests
            // .addFilterBefore(new JWTLoginFilter("/api/v1/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
             // And filter other requests to check the presence of JWT in header
            // .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
     }

}