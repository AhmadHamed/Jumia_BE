package com.jumia.repos;

import com.jumia.entities.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends PagingAndSortingRepository<Customer, Integer> {
  List<Customer> findAll();
}
