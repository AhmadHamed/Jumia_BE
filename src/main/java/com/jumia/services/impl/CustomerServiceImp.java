package com.jumia.services.impl;

import com.jumia.entities.Customer;
import com.jumia.repos.CustomerRepo;
import com.jumia.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements ICustomerService {
  private final CustomerRepo customerRepo;

  @Override
  public Page<Customer> getPaginatedCustomers(Pageable pageable) {
    return customerRepo.findAll(pageable);
  }
}
