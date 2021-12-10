package com.jumia.services.impl;

import com.jumia.dto.CustomerResponseDto;
import com.jumia.repos.CustomerRepo;
import com.jumia.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

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
  public List<CustomerResponseDto> getAllCustomers(String country, Boolean state) {
    log.info("Getting all customers at: {}", LocalDateTime.now());

    List<CustomerResponseDto> customersResponseDtos = new ArrayList<>();
    getUnfilteredData(customersResponseDtos);

    if (isNull(country) && isNull(state)) {
      return customersResponseDtos;
    } else {
      return filterData(customersResponseDtos, country, state);
    }
  }

  private void getUnfilteredData(List<CustomerResponseDto> customersResponseDtos) {
    customerRepo
        .findAll()
        .forEach(
            customer -> {
              customersResponseDtos.add(CustomerResponseDto.getCustomerResponseFromModel(customer));
            });
  }

  private List<CustomerResponseDto> filterData(
      List<CustomerResponseDto> customersResponseDtos, String country, Boolean state) {

    if (!isNull(country)) {
      customersResponseDtos =
          customersResponseDtos.stream()
              .filter(customerResponseDto -> customerResponseDto.getCountry().equals(country))
              .collect(Collectors.toList());
    }
    if (!isNull(state)) {
      customersResponseDtos =
          customersResponseDtos.stream()
              .filter(customerResponseDto -> customerResponseDto.getState().equals(state))
              .collect(Collectors.toList());
    }
    return customersResponseDtos;
  }
}
