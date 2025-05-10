// // src/main/java/com/northwind/config/SecurityConfig.java
// package com.northwind.config;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             // Disable CSRF for APIs (adjust as needed)
//             .csrf().disable()
//             .authorizeRequests()
//                 // Allow public access to actuator and swagger endpoints if needed
//                 .antMatchers("/actuator/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                 // Protect all other endpoints
//                 .anyRequest().authenticated()
//             .and()
//                 // Customize the authentication process so that any unauthenticated access is redirected to Google
//                 .exceptionHandling()
//                     .authenticationEntryPoint((request, response, authException) -> 
//                         response.sendRedirect("/oauth2/authorization/google")
//                     )
//             .and()
//                 // Enable OAuth2 Login with a custom login page that points directly to Google
//                 .oauth2Login()
//                     .loginPage("/oauth2/authorization/google");
//     }
// }
