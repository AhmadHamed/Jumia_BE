package com.jumia.services;

import com.jumia.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
  Page<Customer> getPaginatedCustomers(Pageable pageable);
}
