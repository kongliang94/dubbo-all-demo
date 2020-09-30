package com.github;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 通过自定义REST协议，直接从网关访问到Service
 */
@EnableDiscoveryClient
@SpringBootApplication
public class RestDubboApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RestDubboApp.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
