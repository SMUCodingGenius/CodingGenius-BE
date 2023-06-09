package com.codingGenius.coding_genius.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    private final long MAX_AGE_SECS = 3600; //1H

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOriginPatterns("*") // 외부에서 들어오는 모든 url을 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용되는 Method
                .allowedHeaders("*") // 허용되는 헤더
                .allowCredentials(false) // 자격증명 허용
                .maxAge(MAX_AGE_SECS); // 허용 시간
    }

    //passwordEncoder
    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");

    }
}


