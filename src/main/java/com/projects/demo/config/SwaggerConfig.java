package com.projects.demo.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi v1Api(){
        return GroupedOpenApi.builder()
                        .group("version 1")
                         .pathsToMatch("/api/v1/**")
                            .build();
    }
    @Bean
    public GroupedOpenApi v2Api(){
        return GroupedOpenApi.builder()
                .group("version 2")
                .pathsToMatch("/api/v2/**")
                .build();
    }
}
