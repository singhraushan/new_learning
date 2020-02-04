package com.rau.sentosa.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rau.sentosa.dto.InputOutputdto;
import com.rau.sentosa.service.CurrencyService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/currency")
@RestController
public class Controller {

	
	@Autowired
	public CurrencyService currencyService;
	
	@ApiOperation(value = "All currency exchange Rate")
	@RequestMapping(value = "/AllRate", method = RequestMethod.GET)
	public List<InputOutputdto> showAllRate() {//  
		return currencyService.showAllRate();
	}
	
	@ApiOperation(value = "currency exchange Rate")
	@RequestMapping(value = "/exchangeRate", method = RequestMethod.GET)
	public InputOutputdto exchangeRate(@RequestParam("currency") String currency) {// need input and output currency type and 
		return currencyService.exchangeRate(currency);
	}

	@ApiOperation(value = "currency exchange Amount")
	@RequestMapping(value = "/exchangeAmount", method = RequestMethod.GET)
	public double exchangeAmount(@RequestParam("currency") String currency,@RequestParam("amount") Double amount) {
		return currencyService.exchangeAmount(currency,amount);
	}

	@ApiOperation(value = "Record exchange transaction details")
	@RequestMapping(value = "/currencyTransaction", method = RequestMethod.POST)
	public void currencyTransaction(@RequestBody InputOutputdto inputOutputdto) {
		currencyService.currencyTransaction(inputOutputdto);
	}

	

}
