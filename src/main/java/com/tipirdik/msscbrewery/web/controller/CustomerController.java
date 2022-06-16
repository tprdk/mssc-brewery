package com.tipirdik.msscbrewery.web.controller;

import com.tipirdik.msscbrewery.web.model.CustomerDto;
import com.tipirdik.msscbrewery.web.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto createdCustomer = customerService.createCustomer(customerDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdCustomer.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("customerId") UUID customerId,
                                                 @RequestBody CustomerDto customerDto){
        CustomerDto updatedCustomer = customerService.updateCustomerById(customerId, customerDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .replacePath("/{customerId}")
                .buildAndExpand(updatedCustomer.getId())
                .toUri();
        return ResponseEntity.noContent().location(location).build();
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer (@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomerById(customerId);
    }
}
