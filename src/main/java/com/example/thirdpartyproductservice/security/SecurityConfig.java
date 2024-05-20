package com.example.thirdpartyproductservice.security;


import org.apache.catalina.filters.HttpHeaderSecurityFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> {
                            try {
                                requests
                                        .anyRequest().authenticated()
                                        .and().cors().disable()
                                        .csrf().disable();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                );

//        .authorizeHttpRequests(authorize -> authorize
//        .requestMatchers("products/**").hasAuthority("SCOPE_ADMIN")
//                .anyRequest().permitAll()
//        );
//                .oauth2ResourceServer((oauth2)-> aouth2.jwt(Customizer.withDefaults()));

        return http.build();
    }
}
