package com.noobug.SpringBoot2Template.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public class JWTFilter implements WebFilter {

    private final Logger log = LoggerFactory.getLogger(JWTFilter.class);

    public final static String AUTHORIZATION_HEADER = "Authorization";

    private TokenProvider tokenProvider;

    public JWTFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    private String resolveToken(ServerWebExchange serverWebExchange) {
        String bearerToken = serverWebExchange.getRequest().getHeaders().getFirst(AUTHORIZATION_HEADER);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {

        return ServerWebExchangeMatchers.pathMatchers("/api/admin/get2").matches(serverWebExchange)
                .filter(matchResult -> !matchResult.isMatch())
                .flatMap(matchResult -> webFilterChain.filter(serverWebExchange).then(Mono.empty()));

        /*if (isSkipAuthURL(serverWebExchange.getRequest().getPath().value())) {
            serverWebExchange.getResponse().setStatusCode(HttpStatus.OK);
            return webFilterChain.filter(serverWebExchange);
        } else {
            try {
                String jwt = resolveToken(serverWebExchange);
                if (StringUtils.hasText(jwt)) {
                    if (tokenProvider.validateToken(jwt)) {
                        Authentication authentication = tokenProvider.getAuthentication(jwt);
                        SecurityContextHolder.getContext().setAuthentication(authentication);

                        serverWebExchange.getResponse().getHeaders()
                                .add(HttpHeaders.AUTHORIZATION, "Bearer " + tokenProvider.createToken(authentication, true));
                        webFilterChain.filter(serverWebExchange);
                    }
                } else {
                    serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    webFilterChain.filter(serverWebExchange);
                }
            } catch (ExpiredJwtException e) {
                log.warn("[鉴权失败] 用户 {} - {}", e.getClaims().getSubject(), e.getMessage());
                serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return webFilterChain.filter(serverWebExchange).then(Mono.empty());
            }
        }

        return Mono.empty();*/
    }

    private boolean isSkipAuthURL(String url) {
        if ("/api/admin/get2".equals(url)) {
            return true;
        }
        return false;
    }
}
