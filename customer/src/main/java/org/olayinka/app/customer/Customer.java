package org.olayinka.app.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence_id",
            sequenceName = "customer_sequence_id"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "customer_sequence_id")
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;

}
