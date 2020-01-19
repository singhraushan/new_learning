package com.singtel.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singtel.demo.data.DummyData;
import com.singtel.demo.model.Animal;
import com.singtel.demo.model.Bird;
import com.singtel.demo.model.Butterfly;
import com.singtel.demo.model.Swimmable;

@Service
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	public DummyData dummyData;

	@Override
	public long walkCount() {
		return dummyData.createData().stream().filter(animal -> animal.isWalking()).count();
	}

	@Override
	public long swimCount() {
		return dummyData.createData().stream().filter(animal -> {
			if (animal instanceof Swimmable) {
				return ((Swimmable) animal).IsSwimmable();
			} else {
				return false;
			}
		}).count();
	}

	@Override
	public long flyCount() {
		return dummyData.createData().stream().filter(animal -> {
			if (animal instanceof Bird) {
				return ((Bird) animal).isFlying();
			} else if (animal instanceof Butterfly) {
				return ((Butterfly) animal).isFlying();
			} else {
				return false;
			}
		}).count();
	}

	@Override
	public long singCount() {
		return dummyData.createData().stream().filter(animal -> {
			if (animal instanceof Bird) {
				return ((Bird) animal).isSinging();
			} else {
				return false;
			}
		}).count();
	}

}
