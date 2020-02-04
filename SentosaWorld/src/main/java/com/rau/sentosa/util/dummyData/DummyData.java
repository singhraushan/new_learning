package com.rau.sentosa.util.dummyData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rau.sentosa.dto.InputOutputdto;
import com.rau.sentosa.util.CurrencyType;

@Component
public class DummyData {
	private static List<InputOutputdto> allList = new ArrayList<InputOutputdto>();

	static {
		allList.add(new InputOutputdto(CurrencyType.SGD, CurrencyType.USD, new BigDecimal(1)));
		allList.add(new InputOutputdto(CurrencyType.USD, CurrencyType.SGD, new BigDecimal(1)));
	}

	public List<InputOutputdto> getAllRate() {
		return allList;
	}
	
	public void add(InputOutputdto inputOutputdto) {
		 allList.add(inputOutputdto);
	}

}
