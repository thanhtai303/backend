package com.project.healthcare.Supporter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
  @Bean
  public OpenAPI healthMonitoringOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Health Monitoring System API")
            .description("API documentation for Health Monitoring System")
            .version("1.0.0")
            .contact(new Contact()
                .name("Support Team")
                .email("support@healthmonitoring.com")));
  }
}