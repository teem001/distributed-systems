package org.olayinka.app;

import org.olayinka.app.notification.NotificationMQConfig;
import org.olayinka.app.rabbitmqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "org.olayinka.app.rabbitmqp",
                "org.olayinka.app.notification"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "org.olayinka.app.clients"
)
public class NotificationApplication {
    public static void main(String[] args) {

        SpringApplication.run(NotificationApplication.class);

    }
//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer messageProducer, NotificationMQConfig config){
//        return args -> {
//            messageProducer.publish("foo", config.getInternalExchange(),config.getInternalNotificationRoutingKey());
//
//        };
//    }
}