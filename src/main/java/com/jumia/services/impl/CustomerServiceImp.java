package com.jumia.services.impl;

import com.jumia.CustomerResponseDto;
import com.jumia.entities.Customer;
import com.jumia.repos.CustomerRepo;
import com.jumia.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImp implements ICustomerService {
  private final CustomerRepo customerRepo;

  @Override
  public List<CustomerResponseDto> getPaginatedCustomers(Pageable pageable) {
    log.info("Getting paginated customers with pageable: {} at: {}", pageable, LocalDateTime.now());
    List<CustomerResponseDto> customersResponseDtos = new ArrayList<>();
    customerRepo
        .findAll(pageable)
        .forEach(
            customer -> {
              customersResponseDtos.add(CustomerResponseDto.getCustomerResponseFromModel(customer));
            });
    return customersResponseDtos;
  }

  @Override
  public List<CustomerResponseDto> getAllCustomers() {
    log.info("Getting all customers at: {}", LocalDateTime.now());

    List<CustomerResponseDto> customersResponseDtos = new ArrayList<>();

    customerRepo
        .findAll()
        .forEach(
            customer -> {
              customersResponseDtos.add(CustomerResponseDto.getCustomerResponseFromModel(customer));
            });
    return customersResponseDtos;
  }
}
