package org.dnyanyog.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class RouterConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth_public_route", r -> r.path("/api/v1/public/auth/**").uri("http://localhost:8081"))
                .route("auth_route", r -> r.path("/api/v1/auth/**").uri("http://localhost:8081"))
                .route("customer_route", r -> r.path("/api/v1/customer/**").uri("http://localhost:8083"))
                .build();
    }
}
