package io.github.projetopi.pi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI customizacaoOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("APIs-CliniGest")
                        .version("v1-0"));
    }
}
