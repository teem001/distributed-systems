package org.olayinka.app.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @SequenceGenerator(
            name = "notification_sequence_id",
            sequenceName ="notification_sequence_id"
    )
    @Id
    @GeneratedValue(
            generator = "notification_sequence_id",
            strategy = GenerationType.SEQUENCE
    )
    private Integer notificationId;
    private LocalDateTime sentAt;
    private String message;
    private String sender;
    private String receiverEmail;
    private Integer customerId;

    @PrePersist
    public void setSender(){
        this.sender = "Olayinka";
        this.sentAt = LocalDateTime.now();
    }
}
