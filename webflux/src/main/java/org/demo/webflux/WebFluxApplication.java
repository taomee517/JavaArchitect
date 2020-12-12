package org.demo.webflux;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WebFluxApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .web(WebApplicationType.REACTIVE)
                .sources(WebFluxApplication.class)
                .run(args);
    }
}
