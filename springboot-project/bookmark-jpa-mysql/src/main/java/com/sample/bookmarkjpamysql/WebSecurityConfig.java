package com.sample.bookmarkjpamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sample.bookmarkjpamysql.web.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests().antMatchers("/css/**").permitAll()
        .and()
        .authorizeRequests().anyRequest().authenticated()
        .and()
      .formLogin()
          .defaultSuccessUrl("/bookmarks", true)
          .permitAll()
          .and()
      .logout()
          .permitAll();
    }

    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}