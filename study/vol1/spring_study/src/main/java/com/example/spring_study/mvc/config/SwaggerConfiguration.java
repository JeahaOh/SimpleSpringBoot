package com.example.spring_study.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



/**
 * Swag 넘치는 Swagger 설정
 * Created by jeaha on 2023/06/25
 */
@Configuration
@EnableWebMvc
public class SwaggerConfiguration {
    @Bean
    public Docket docket() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Document of API Server");
        apiInfoBuilder.description("Document of API Server");
        
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(apiInfoBuilder.build());
    
        ApiSelectorBuilder apis = docket.select().apis(RequestHandlerSelectors.basePackage("com.example.spring_study.mvc.controller"));
        apis.paths(PathSelectors.ant("/**"));
        
        return apis.build();
    }
}
