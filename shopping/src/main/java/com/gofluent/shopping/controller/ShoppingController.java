package com.gofluent.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gofluent.shopping.model.Cart;
import com.gofluent.shopping.model.Customer;
import com.gofluent.shopping.service.ShoppingService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ShoppingController {

	@Autowired
	ShoppingService shoppingService;
	
	@ApiOperation(value = "List all customers")
	@RequestMapping(value = "/customers", method=RequestMethod.GET)  
    public List<Customer> customers(){  
        return shoppingService.findAllCustomers();  
    }
	
	@ApiOperation(value = "A list of all the items of a basket")
	@RequestMapping(value = "/list", method=RequestMethod.GET)  
    public List<Cart> cartList(@RequestParam("customerId") Integer customerId){  
        return shoppingService.findAllCart(customerId);  
    } 
	
	@ApiOperation(value = "Get the total price on all the baskets of the customer")
	@RequestMapping(value = "/total", method=RequestMethod.GET)  
    public Double totalPrice(@RequestParam("customerId") Integer customerId){  
        return shoppingService.findTotalPrice(customerId);  
    } 
	
	@ApiOperation(value = "Create a basket for the customer")
	@RequestMapping(value = "/create", method=RequestMethod.POST)  
    public Cart saveCart(@RequestBody Cart cart){  
        return shoppingService.saveCart(cart);  
    } 
	
	@ApiOperation(value = "Add items inside the basket")
	@RequestMapping(value = "/edit", method=RequestMethod.PUT)  
    public Cart editCart(@RequestBody Cart cart){  
        return shoppingService.editCart(cart);  
    } 
	
	@ApiOperation(value = "Remove items inside the basket")
	@RequestMapping(value = "/remove", method=RequestMethod.DELETE)  
    public String removeCart(@RequestBody Cart cart){  
        return shoppingService.removeCart(cart);  
    } 
}
