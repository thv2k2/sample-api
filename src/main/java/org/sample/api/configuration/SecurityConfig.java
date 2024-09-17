package org.sample.api.configuration;

import org.sample.common.numberic.RoleUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf. disable())
                .authorizeRequests()
                .requestMatchers("/api/v1/*").permitAll()
                .requestMatchers("/api/v1/convert/*").hasRole(RoleUser.USER.getRole());
        return http.build();
    }
}
