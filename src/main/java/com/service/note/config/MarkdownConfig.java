package com.service.note.config;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MarkdownConfig {

    @Value("${spring.servlet.multipart.location}")
    private String location;

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigElement(location);
    }
}
