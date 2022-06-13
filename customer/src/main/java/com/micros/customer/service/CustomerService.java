package com.micros.customer.service;

import com.micros.customer.model.Customer;
import com.micros.customer.model.CustomerRegistrationRequest;
import com.micros.customer.repository.CustomerRepository;
import com.micros.fraud.model.FraudCheckResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private final RestTemplate restTemplate;
    private final CustomerRepository customerRepository;

    public CustomerService(RestTemplate restTemplate, CustomerRepository customerRepository) {
        this.restTemplate = restTemplate;
        this.customerRepository = customerRepository;
    }

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse response = restTemplate.getForObject(
                "http://fraud/api/v1/fraud-check/{customerId}", FraudCheckResponse.class,
                customer.getId()
        );
        if (response.getFraudster()) {
            throw new IllegalStateException("fraudster");
        }

    }
}
