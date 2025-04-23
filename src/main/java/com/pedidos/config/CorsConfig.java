package com.pedidos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://localhost:4200", "https://cardinalidade-production.up.railway.app")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "HEAD")
                .allowedHeaders("*");
    }
}
