package org.olayinka.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "org.olayinka.app.clients"
)
public class FraudApplication {
    public static void main(String[] args) {

        SpringApplication.run(FraudApplication.class);
    }
}