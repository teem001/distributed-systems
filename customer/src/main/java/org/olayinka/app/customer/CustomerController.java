package org.olayinka.app.customer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
@Slf4j
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public  void saveCustomer(@RequestBody CustomerResponse customerResponse){
        log.info("save customer {} ", customerResponse);
        customerService.saveCustomer(
                customerResponse
        );
    }


}
