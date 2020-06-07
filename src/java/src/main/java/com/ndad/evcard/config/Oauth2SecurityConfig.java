//package com.ndad.evcard.config;
//
//import com.ndad.evcard.services.UserService;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity(debug = true)
//public class Oauth2SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserService userService;
//
//    public Oauth2SecurityConfig(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/v1/evcard/email/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .oauth2Login()
//                .redirectionEndpoint()
//                .baseUri("/oauth2/callback/*")
//                .and()
//                .userInfoEndpoint()
//                .oidcUserService(userService);
//
//    }
//
//}
