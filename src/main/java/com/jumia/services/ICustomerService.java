package com.jumia.services;

import com.jumia.dto.CustomerResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
  List<CustomerResponseDto> getPaginatedCustomers(Pageable pageable);

  List<CustomerResponseDto> getAllCustomers(String country, Boolean state);
}
