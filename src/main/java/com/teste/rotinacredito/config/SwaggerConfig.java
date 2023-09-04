package com.teste.rotinacredito.config;

import org.springframework.context.annotation.Configuration;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
@Configuration
public class SwaggerConfig {

    @Value("${rotina.credito.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("\"N/A");
        contact.setName("Rotina de Crédito");
        contact.setUrl("N/A");

        License mitLicense = new License().name("N/A").url("");

        Info info = new Info()
                .title("Tutorial Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials.").termsOfService("")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}

//
//@EnableSwagger2
//@Import(SpringDataRestConfiguration.class)
//public class SwaggerConfig {
//
//
//    @Bean
//    public Docket apiDocket() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.teste.rotinacredito.controller"))
//                .paths(regex("(/controle-conta.*)|(/controle-transacoes.*)"))
//                .build()
//                .apiInfo(metaData());
//    }
////    @Bean
////    public Docket postsApi() {
////        return new Docket(DocumentationType.SWAGGER_2)
////                .select()
////                .apis(RequestHandlerSelectors.any())
////                .paths(PathSelectors.any())
////                .build();
////    }
//
//    private ApiInfo metaData() {
//        return new ApiInfoBuilder()
//                .title("Rotina de Crédito API")
//                .description("\"API de teste\"")
//                .version("1.0.0")
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//                .build();
//    }
////
////    private Predicate<String> postPaths() {
////        return or(regex("/rotinacredito.*"), regex("/rotinacredito.*"));
////    }
////
////    private ApiInfo apiInfo() {
////        return new ApiInfoBuilder().title("Rotina de Crédito API")
////                .description("API de teste")
////                .termsOfServiceUrl("")
////                .contact("").license("")
////                .licenseUrl("").version("1.0").build();
////    }
//
//}

