package com.rau.sentosa.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.rau.sentosa.util.CurrencyType;

public class InputOutputdto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3567240411100599767L;

	private CurrencyType inputCurrency;

	private CurrencyType outputCurrency;

	private BigDecimal inputAmount;

	private BigDecimal outputAmount;

	public InputOutputdto(){
		
	}
	public InputOutputdto(CurrencyType inputCurrency, CurrencyType outputCurrency, BigDecimal inputAmount) {
		this.inputCurrency = inputCurrency;
		this.outputCurrency = outputCurrency;
		this.inputAmount = inputAmount;
		outputAmount= inputCurrency.rate.multiply(inputAmount);
	}
	

	public CurrencyType getInputCurrency() {
		return inputCurrency;
	}

	public void setInputCurrency(CurrencyType inputCurrency) {
		this.inputCurrency = inputCurrency;
	}

	public CurrencyType getOutputCurrency() {
		return outputCurrency;
	}

	public void setOutputCurrency(CurrencyType outputCurrency) {
		this.outputCurrency = outputCurrency;
	}

	public BigDecimal getInputAmount() {
		return inputAmount;
	}

	public void setInputAmount(BigDecimal inputAmount) {
		this.inputAmount = inputAmount;
	}

	public BigDecimal getOutputAmount() {
		return outputAmount;
	}

	public void setOutputAmount(BigDecimal outputAmount) {
		this.outputAmount = outputAmount;
	}

}
