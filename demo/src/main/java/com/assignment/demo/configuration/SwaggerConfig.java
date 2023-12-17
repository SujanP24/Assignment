package com.assignment.demo.configuration;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;

import java.util.List;

@Configuration
public class SwaggerConfig {

//    @Bean
//    public OpenApiCustomiser openApiCustomiser() {
//        return openApi -> openApi
//                .info(new Info().title("Your API Title").version("1.0").description("Your API Description"))
//                .externalDocs(new ExternalDocumentation().description("Your External Documentation Description").url("Your External Documentation URL"))
//                .servers(List.of(new Server().url("http://localhost:8080").description("Your Server Description")))
//                .components(new Components())
//                .tags(List.of(new Tag().name("Your Tag Name").description("Your Tag Description")))
//                .addSecurityItem(new SecurityRequirement().addList("Your Security Schema Name"));
//    }

    @Bean
    public GroupedOpenApi actuatorApi() {
        return GroupedOpenApi.builder()
                .group("actuator")
                .pathsToMatch("/actuator/**")
                .build();
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.assignment.demo.controller") // Adjust the package name
                .pathsToMatch("/**") // Adjust the path pattern as needed
                .build();
    }

}
