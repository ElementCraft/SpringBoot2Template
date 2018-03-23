package com.noobug.SpringBoot2Template.web.rest;

import com.noobug.SpringBoot2Template.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/admin")
public class AdminResource {

    @GetMapping("/get1")
    public Mono<String> get1() {
        return Mono.just("123");
    }

    @GetMapping("/get2")
    public Flux<String> get2(String account, String password) {

        int a = 1;
        return Flux.just("123");
    }
}
