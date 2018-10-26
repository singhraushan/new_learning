package com.gofluent.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gofluent.shopping.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
