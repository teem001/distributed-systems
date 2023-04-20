package org.olayinka.app.customer;

import lombok.AllArgsConstructor;
import org.olayinka.app.clients.fraud.FraudClient;
import org.olayinka.app.clients.fraud.FraudResponse;
import org.olayinka.app.clients.notification.NotificationClient;
import org.olayinka.app.clients.notification.NotificationRequest;
import org.olayinka.app.rabbitmqp.RabbitMQMessageProducer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private  final  CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient client;
    private final RabbitMQMessageProducer producer;


    public void saveCustomer(CustomerResponse customerResponse){

          Customer customer =Customer.builder()
                        .firstName(customerResponse.getFirstName())
                        .lastName(customerResponse.getLastName())
                        .email(customerResponse.getEmail()).build();
          customerRepository.saveAndFlush(customer);

//       FraudResponse response =  restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud/{id}",
//                FraudResponse.class,
//                customer.getCustomerId()
//                );
        //check if customer is fraud
       FraudResponse fraudResponse = fraudClient
               .isFraudulent(customer.getCustomerId());



        assert fraudResponse != null;
        if(fraudResponse.getIsFraud()) throw new IllegalStateException("this customer is a fraud");
        //Notification Request
        NotificationRequest request =new NotificationRequest(customer.getCustomerId(),
                customer.getEmail(),
                String.format("Hello %s ,\n Welcome to Olayinka microservice",customer.getFirstName() ));
        //Send notification to the customer
//        client.sendNotification(request);

        producer.publish(request,"internal.exchange","internal.notification.routing-key");
//        producer.publish();

       customerRepository.save(customer);
    }



}
