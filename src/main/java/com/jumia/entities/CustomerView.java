package com.jumia.entities;

import lombok.Getter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Immutable
@Getter
public class CustomerView {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String phone;
  private String countryCode;
  private String country;
}
