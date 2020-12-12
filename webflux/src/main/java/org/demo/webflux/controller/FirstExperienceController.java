package org.demo.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "first")
public class FirstExperienceController {

    @GetMapping(value = "common")
    public String commonHandle(){
        return "common handle";
    }

    @GetMapping(value = "webflux")
    public Mono<String> webfluxHandle(){
        return Mono.just("Hello! Webflux");
    }
}
