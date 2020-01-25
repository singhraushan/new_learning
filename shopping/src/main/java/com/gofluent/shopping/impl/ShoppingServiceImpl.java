package com.gofluent.shopping.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gofluent.shopping.model.Cart;
import com.gofluent.shopping.model.Customer;
import com.gofluent.shopping.repository.CartRepository;
import com.gofluent.shopping.repository.CustomerRepository;
import com.gofluent.shopping.repository.ProductRepository;
import com.gofluent.shopping.service.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}
	
	@Override
	public List<Cart> findAllCart(Integer customerId) {
		List<Cart> carts = new ArrayList<>();
		if(customerId != null){
			Customer customer = customerRepository.findOne(customerId);
			carts = cartRepository.findByCustomer(customer);
		}else{
			carts = cartRepository.findAll();
		}
		return carts;
	}

	@Override
	public Double findTotalPrice(Integer customerId) {
		List<Cart> carts = findAllCart(customerId);
		Double total = 0.0;
		for(Cart cart : carts){
			total += cart.getProduct().getPrice() * cart.getQty();
		}
		return total;
	}

	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public Cart saveCart(Cart cart) {
		if(cart.getCustomer().getId() == null || cart.getCustomer().getId() == 0){//new customer
			customerRepository.saveAndFlush(cart.getCustomer());
		}
		if(cart.getProduct().getId() == null || cart.getProduct().getId() == 0){// adding in product  
			productRepository.saveAndFlush(cart.getProduct());
		}
		return cartRepository.saveAndFlush(cart); // adding in product 
	}

	
	@Override
	@Transactional(noRollbackFor=Exception.class)
	public Cart editCart(Cart cart) {
		return saveCart(cart);
	}
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String removeCart(Cart cart) {
		try{
			cartRepository.delete(cart);// delete from cart 
		}catch(Exception e){
			return "ERROR";
		}
		return "SUCCESS";
	}

}
