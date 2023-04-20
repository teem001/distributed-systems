package org.olayinka.app.notification;

import lombok.AllArgsConstructor;
import org.olayinka.app.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public void sendNotification(NotificationRequest request){

        repository.save(
                Notification.builder()
                        .receiverEmail(request.getCustomerEmail())
                        .message(request.getMessage())
                        .customerId(request.getCustomerId())
                        .build()
        );



    }
}
