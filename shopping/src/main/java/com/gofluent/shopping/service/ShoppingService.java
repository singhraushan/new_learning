package com.gofluent.shopping.service;

import java.util.List;

import com.gofluent.shopping.model.Cart;
import com.gofluent.shopping.model.Customer;

public interface ShoppingService {

	List<Customer> findAllCustomers();
	
	List<Cart> findAllCart(Integer customerId);
	
	Double findTotalPrice(Integer customerId);

	Cart saveCart(Cart cart);

	Cart editCart(Cart cart);
	
	String removeCart(Cart cart);
}
