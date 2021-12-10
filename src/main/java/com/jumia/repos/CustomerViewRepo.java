package com.jumia.repos;

import com.jumia.entities.CustomerView;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerViewRepo extends ReadOnlyRepo<CustomerView, Integer> {}
