package com.tipirdik.msscbrewery.web.service;

import com.tipirdik.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService implements ICustomerService{

    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder()
                .id(id)
                .name("Customer")
                .build();
    }
}
