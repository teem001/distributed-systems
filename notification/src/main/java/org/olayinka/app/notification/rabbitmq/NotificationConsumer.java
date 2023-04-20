package org.olayinka.app.notification.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.olayinka.app.clients.notification.NotificationRequest;
import org.olayinka.app.notification.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService service;


    @RabbitListener(
            queues = "${rabbitmq.queues.notification}"
    )
    public void consumer(NotificationRequest request){
        log.info("consumed {} from queue", request);
        service.sendNotification(request);
    }
}
