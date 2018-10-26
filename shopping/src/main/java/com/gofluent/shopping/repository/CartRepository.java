package com.gofluent.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gofluent.shopping.model.Cart;
import com.gofluent.shopping.model.Customer;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {

	List<Cart> findByCustomer(Customer customer);

}
