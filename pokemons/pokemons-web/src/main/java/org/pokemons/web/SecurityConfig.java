package org.pokemons.web;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
            x -> x.requestMatchers("/api/v1/pokemon/all").permitAll().anyRequest().authenticated()
        ).formLogin(formLogin ->
                formLogin.defaultSuccessUrl("/api/v1/pokemon/all", true).permitAll()
        ).logout(logout -> logout.logoutSuccessUrl("/login"));
        return httpSecurity.build();
    }
}
