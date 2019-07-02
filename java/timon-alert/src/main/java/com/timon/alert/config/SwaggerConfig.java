package com.timon.alert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {

//        new UiConfiguration(
//                "http://localhost:8080/swagger",
//                "none",
//                "alpha",
//                "schema",
//                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
//                false,
//                true);
        return UiConfigurationBuilder.builder()
                .validatorUrl("http://localhost:8080/swagger")
                .docExpansion(null)
                .defaultModelRendering( ModelRendering.of("schema"))
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Alert REST API",
                "Alert REST API.",
                "API TOS",
                "Terms of service",
                new Contact("Tico", "www.tico.cn", "support@tico.cn"),
                "License of API", "API license URL", Collections.emptyList());
    }
}
