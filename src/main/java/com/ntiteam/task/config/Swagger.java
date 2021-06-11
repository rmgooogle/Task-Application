package com.ntiteam.task.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI metaData() {
        return new OpenAPI()
                .info(new Info()
                        .title("Masters and Planets REST API")
                        .description("\"Spring Boot REST API for NTI team\"")
                        .version("1.0.0")
                        .contact(new Contact()
                            .name("Igor Kretov")
                            .url("https://github.com/rmgooogle")
                            .email("rm.gooogle@gmail.com")));
    }
}
