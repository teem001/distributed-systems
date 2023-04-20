package org.olayinka.app.notification;

import lombok.AllArgsConstructor;
import org.olayinka.app.clients.notification.NotificationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
public class NotificationController {
    private final  NotificationService service;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest request){

         service.sendNotification(request);

    };
}
