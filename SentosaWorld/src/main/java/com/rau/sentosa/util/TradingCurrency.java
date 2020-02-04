package com.rau.sentosa.util;

import java.math.BigDecimal;

public interface TradingCurrency {

	public BigDecimal getExchangeRate(Currency targetCurrency);
	
	public BigDecimal getExchangeAmount(Currency targetCurrency);
	
}
