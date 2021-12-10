package com.jumia.services;

import com.jumia.CustomerResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
  List<CustomerResponseDto> getPaginatedCustomers(Pageable pageable);

  List<CustomerResponseDto> getAllCustomers();
}
