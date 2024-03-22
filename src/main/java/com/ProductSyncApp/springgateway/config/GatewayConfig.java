package com.ProductSyncApp.springgateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {
    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/v1/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://USERSERVICEAPP"))
                .route(p -> p
                        .path("/emailservice/**")
                        .uri("http://EMAILSERVICE")).
                build();
    }
}
