package com.albino.PayGoal.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return  new OpenAPI().info(new Info()
                .title("Api rest de productos con spring")
                .version("1.0")
                .contact(new Contact().name("Yonathan")
                        .url("https://www.linkedin.com/in/yonathan-albino/")
                        .email("yonaalbino5@gmail.com"))
                .license(new License()
                        .url("xxx")
                        .name("xxx"))
                .termsOfService("xxx")
                .description("Esta api se utiliza para realizar un crud de productos"));
    }
}
