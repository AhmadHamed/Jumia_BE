package com.jumia.controllers;

import com.jumia.dto.CustomerResponseDto;
import com.jumia.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final ICustomerService customerService;

  /**
   * @param pageable [page, size, sort, direction]
   * @return paginated customer response
   */
  @GetMapping
  public ResponseEntity<List<CustomerResponseDto>> getPaginatedCustomers(
      @PageableDefault Pageable pageable) {
    List<CustomerResponseDto> paginatedCustomers = customerService.getPaginatedCustomers(pageable);
    return ResponseEntity.ok(paginatedCustomers);
  }
  /** @return list of all customer response */
  @GetMapping("/get-all")
  public ResponseEntity<List<CustomerResponseDto>> getAllCustomers(
      @RequestParam(required = false) String country,
      @RequestParam(required = false) Boolean state) {
    List<CustomerResponseDto> customersList = customerService.getAllCustomers(country, state);
    return ResponseEntity.ok(customersList);
  }
}
