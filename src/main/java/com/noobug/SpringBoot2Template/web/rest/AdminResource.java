package com.noobug.SpringBoot2Template.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/admin")
public class AdminResource {

    @GetMapping("/get1")
    public Mono<String> get1() {
        return Mono.just("123");
    }

    @GetMapping("/get2")
    public String get2() {
        return "123";
    }
}
