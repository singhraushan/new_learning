package com.rau.sentosa.service;

import java.util.List;

import com.rau.sentosa.dto.InputOutputdto;
import com.rau.sentosa.exception.CustomException;

public interface CurrencyService {
	
	public List<InputOutputdto> showAllRate();
	public InputOutputdto exchangeRate(String currency);
	public double exchangeAmount(String currency,Double amount) throws CustomException;
	public void currencyTransaction(InputOutputdto inputOutputdto) ;

}
