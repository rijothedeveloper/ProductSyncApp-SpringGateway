package com.ProductSyncApp.springgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringGatewayApplication {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/api/v1/auth/**")
                        .uri("http://localhost:8081"))
                .route(p -> p
                        .path("/emailservice/**")
                        .uri("http://localhost:8082")).
                build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringGatewayApplication.class, args);
    }

}
