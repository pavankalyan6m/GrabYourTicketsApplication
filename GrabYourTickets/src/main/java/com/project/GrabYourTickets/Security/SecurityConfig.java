package com.project.GrabYourTickets.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;
    private final UserDetailsService userDetailsService;

    public SecurityConfig(JwtRequestFilter jwtRequestFilter, UserDetailsService userDetailsService) {
        this.jwtRequestFilter = jwtRequestFilter;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   /* protected void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests.requestMatchers("/api/users/**").authenticated().anyRequest().permitAll())
                .formLogin(form -> form.disable()) // Disable form-based login
                .httpBasic(httpbasic -> httpbasic.disable()) // Disable HTTP Basic Authentication
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    */

        protected void configure(HttpSecurity http) throws Exception {
            http.csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(requests -> requests
                            .requestMatchers("/welcome/user").permitAll()
                            .requestMatchers("/welcome/hello").permitAll()
                            //.requestMatchers("/admin/authenticate").permitAll()// Allow access to /admin/create without authentication
                            .anyRequest().authenticated()
                    )
                    .formLogin(form -> form.disable())
                    .httpBasic(httpBasic -> httpBasic.disable())
                    .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
           }
        }
