package com.example.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Cross-domain configuration
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1 Set the access source address
        corsConfiguration.addAllowedHeader("*"); // 2 Set the access source request header
        corsConfiguration.addAllowedMethod("*"); // 3 Set the access source request method
        source.registerCorsConfiguration("/**", corsConfiguration); // 4 Configure cross-domain Settings for an API

        return new CorsFilter(source);
    }
}