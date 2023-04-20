package org.olayinka.app.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.olayinka.app.clients.fraud.FraudResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud")
@Slf4j
public class FraudCheckController {
    FraudCheckService fraudCheckService;

    @GetMapping("{id}")
    FraudResponse isFraudulent(@PathVariable("id")Integer customerId){
        log.info("fraud check for request customer {}",customerId );

      return  new FraudResponse(fraudCheckService.isFraudulent(customerId));
    }






}
