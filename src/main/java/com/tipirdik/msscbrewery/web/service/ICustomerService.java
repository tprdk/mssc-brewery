package com.tipirdik.msscbrewery.web.service;

import com.tipirdik.msscbrewery.web.model.CustomerDto;
import java.util.UUID;

public interface ICustomerService {
    CustomerDto getCustomerById(UUID id);
}
