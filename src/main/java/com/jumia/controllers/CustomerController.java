package com.jumia.controllers;

import com.jumia.entities.Customer;
import com.jumia.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<Page<Customer>> getPaginatedCustomers(@PageableDefault Pageable pageable) {
    Page<Customer> paginatedCustomers = customerService.getPaginatedCustomers(pageable);
    return ResponseEntity.ok(paginatedCustomers);
  }
}
