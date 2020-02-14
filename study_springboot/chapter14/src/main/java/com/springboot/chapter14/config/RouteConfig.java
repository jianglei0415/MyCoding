package com.springboot.chapter14.config;

import com.springboot.chapter14.handler.UserHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author: jianglei
 * @date: 2020/2/2 21:45
 */
@Configuration
public class RouteConfig {
    @Autowired
    private UserHandler userHandler;

    private static final String HEADER_NAME = "header_user";
    private static final String HEADER_VALUE = "header_password";

    @Bean
    public RouterFunction<ServerResponse> userRouter() {
        RouterFunction<ServerResponse> router =
                route(GET("/router/user/{id}").
                                and(accept(MediaType.APPLICATION_STREAM_JSON)),
                        userHandler::getUser)
                        .andRoute(POST("/router/user")
                                        .and(contentType(MediaType.APPLICATION_STREAM_JSON))
                                        .and(accept(MediaType.APPLICATION_STREAM_JSON)),
                                userHandler::insertUser)
                        .andRoute(PUT("/router/user")
                                        .and(contentType(MediaType.APPLICATION_STREAM_JSON))
                                        .and(accept(MediaType.APPLICATION_STREAM_JSON)),
                                userHandler::updateUser)
                        .andRoute(DELETE("/router/user/{id}")
                                        .and(accept(MediaType.APPLICATION_STREAM_JSON)),
                                userHandler::deleteUser)
                        .andRoute(PUT("/router/user/name")
                                        .and(accept(MediaType.APPLICATION_STREAM_JSON)),
                                userHandler::updateUserName);
        return router;
    }

    @Bean
    public RouterFunction<ServerResponse> securityRouter() {
        RouterFunction<ServerResponse> router =
                route(
                        GET("/security/user/{id}")
                                .and(accept(MediaType.APPLICATION_STREAM_JSON)),
                        userHandler::getUser)
                        .filter(this::filterLogic);
        return router;
    }

    private Mono<ServerResponse> filterLogic(ServerRequest request, HandlerFunction<ServerResponse> next) {
        String userName = request.headers().header(HEADER_NAME).get(0);
        String password = request.headers().header(HEADER_VALUE).get(0);
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password) && !userName.equals(password)) {
            return next.handle(request);
        }
        return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
    }
}

