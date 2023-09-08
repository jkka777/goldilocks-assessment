package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GoldilockSecureApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoldilockSecureApplication.class, args);
    }

    /*
    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry cr) {
                cr.addMapping("/user/**")
                        .allowedOrigins("http://localhost:8880/")
                        .allowedMethods("GET", "PUT", "POST", "OPTIONS", "DELETE")
                        .allowedHeaders("*")
                        .exposedHeaders("*");
            }
        };
    }
     */
}
