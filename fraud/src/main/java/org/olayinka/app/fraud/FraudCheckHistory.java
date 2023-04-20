package org.olayinka.app.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraudCheckId",
            sequenceName = "fraudCheckId"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraudCheckId"
    )
    private Integer fraudCheckId;
    private  Integer customerId;
    private Boolean isFraud;
    private LocalDateTime createdAt;
}
