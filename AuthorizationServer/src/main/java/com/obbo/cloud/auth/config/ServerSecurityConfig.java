package com.obbo.cloud.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
        auth.inMemoryAuthentication()
          .withUser("wang").password(passwordEncoder().encode("test")).roles("USER");
    }
 
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() 
      throws Exception {
        return super.authenticationManagerBean();
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
