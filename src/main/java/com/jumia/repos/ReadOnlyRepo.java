package com.jumia.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface ReadOnlyRepo<T, ID> extends Repository<T, ID> {
  List<T> findAll();

  Page<T> findAll(Pageable pageable);

  Optional<T> findById(ID id);
}
