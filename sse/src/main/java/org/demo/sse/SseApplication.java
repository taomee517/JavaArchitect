package org.demo.sse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SseApplication {
    public static void main(String[] args) {
//        SpringApplication.run(SseApplication.class);

        new SpringApplicationBuilder()
                .web(WebApplicationType.REACTIVE)
                .sources(SseApplication.class)
                .run(args);
    }
}
