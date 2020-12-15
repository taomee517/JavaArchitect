package org.demo.routerfunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@EnableReactiveMongoRepositories
@SpringBootApplication
public class RouterFunctionApplication {
    public static void main(String[] args) {
        SpringApplication.run(RouterFunctionApplication.class);
    }
}
