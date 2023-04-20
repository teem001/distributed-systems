package org.olayinka.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "org.olayinka.app.customer",
                "org.olayinka.app.rabbitmqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(basePackages = "org.olayinka.app.clients")
public class CustomerApplication {
    public static void main(String[] args) {

        SpringApplication.run(CustomerApplication.class);

    }
}