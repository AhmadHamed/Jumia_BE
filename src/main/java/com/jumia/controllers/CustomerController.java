package com.jumia.controllers;

import com.jumia.CustomerResponseDto;
import com.jumia.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
  public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
    List<CustomerResponseDto> customersList = customerService.getAllCustomers();
    return ResponseEntity.ok(customersList);
  }
}
