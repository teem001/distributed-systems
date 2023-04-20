package org.olayinka.app.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckRepository fraudCheckRepository;

    public Boolean isFraudulent(Integer customerId){
        fraudCheckRepository.save(
              FraudCheckHistory.builder()
                      .customerId(customerId)
                      .isFraud(false)
                      .createdAt(LocalDateTime.now())
                      .build());

        return false;
    }

}
