package com.jumia.repos;

import com.jumia.entities.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends PagingAndSortingRepository<Customer, Integer> {}
