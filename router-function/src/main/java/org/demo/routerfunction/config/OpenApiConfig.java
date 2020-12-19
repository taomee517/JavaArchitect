//package org.demo.routerfunction.config;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import org.springdoc.core.GroupedOpenApi;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * SpringDoc配置参考:https://github.com/springdoc/springdoc-openapi-demos
// */
//@Configuration
//public class OpenApiConfig {
//
//    @Bean
//    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
//        return new OpenAPI()
//                .components(new Components()) //.addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))
//                .info(new Info().title("Webflux API").version(appVersion)
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
//    }
//
//    @Bean
//    public GroupedOpenApi deviceOpenApi() {
//        String paths[] = {"/device/**"};
////        String packagesToscan[] = {"org.demo.routerfunction.controller", "org.demo.routerfunction.handler"};
////        .packagesToScan(packagesToscan)
//        return GroupedOpenApi.builder().group("device").pathsToMatch(paths).build();
//    }
//}
