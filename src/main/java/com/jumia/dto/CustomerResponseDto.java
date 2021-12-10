package com.jumia.dto;

import com.jumia.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import static com.jumia.utils.MatcherUtil.matchCountry;
import static com.jumia.utils.MatcherUtil.matchState;

@Setter
@Getter
public class CustomerResponseDto {
  private String phone;
  private String countryCode;
  private String country;
  private Boolean state;

  public static CustomerResponseDto getCustomerResponseFromModel(Customer customer) {
    CustomerResponseDto customerResponseDto = new CustomerResponseDto();
    customerResponseDto.setPhone(customer.getPhone());
    customerResponseDto.setCountryCode(customer.getPhone().substring(1, 4));
    customerResponseDto.setCountry(matchCountry(customerResponseDto.getCountryCode()));
    customerResponseDto.setState(matchState(customerResponseDto));
    return customerResponseDto;
  }
}
