package org.demo.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * Github webflux example: https://github.com/jittagornp/spring-boot-reactive-example
 */
@EnableR2dbcRepositories
@SpringBootApplication
public class WebFluxApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .web(WebApplicationType.REACTIVE)
                .sources(WebFluxApplication.class)
                .run(args);

        //common run
//        SpringApplication.run(WebFluxApplication.class);
    }
}
