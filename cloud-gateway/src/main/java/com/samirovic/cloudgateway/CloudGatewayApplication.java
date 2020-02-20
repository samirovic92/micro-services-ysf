package com.samirovic.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class CloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }


    //Filters + Fault Tolerance
    @Bean
    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(r -> r.path("/muslimsalat/**")
                        .filters(f -> f
                                .addRequestHeader("x-rapidapi-host", "muslimsalat.p.rapidapi.com")
                                .addRequestHeader("x-rapidapi-key", "96922616b7msh3f120fd91ce7039p1466a0jsn3e2924b67fec")
                                .rewritePath("/muslimsalat/(?<segment>.*)", "/${segment}.json"))
                        .uri("https://muslimsalat.p.rapidapi.com").id("muslimsalat")

                )
                .build();

    }

    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {

        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }
}
