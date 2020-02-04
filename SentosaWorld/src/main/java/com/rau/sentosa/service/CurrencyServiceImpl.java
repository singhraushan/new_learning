package com.rau.sentosa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rau.sentosa.dto.InputOutputdto;
import com.rau.sentosa.exception.CustomException;
import com.rau.sentosa.util.dummyData.DummyData;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	DummyData dummyData;

	@Override
	public List<InputOutputdto> showAllRate() {
		return dummyData.getAllRate();
	}

	@Override
	public InputOutputdto exchangeRate(String currency) {
		return dummyData.getAllRate().stream()
				.filter(dto -> dto.getInputCurrency().name().equalsIgnoreCase(currency))
				.findFirst().orElse(null);

	}

	@Override
	public double exchangeAmount(String currency, Double amount) throws CustomException {
		Optional<InputOutputdto> matched = dummyData.getAllRate().stream()
				.filter(dto -> dto.getOutputCurrency().name().equalsIgnoreCase(currency)
						)
				.findFirst();

		if (matched.isPresent()) {
			return matched.get().getInputCurrency().rate.doubleValue()*amount;
		} else {
			new CustomException("not matched");
		}
		return 0;
	}

	@Override
	public void currencyTransaction(InputOutputdto inputOutputdto) {
		dummyData.add(inputOutputdto);
	}

}
