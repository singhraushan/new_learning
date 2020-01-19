package com.singtel.demo.model;

import com.singtel.demo.util.AnimalBehaviour;
import com.singtel.demo.util.SpecializeFish.Specialize;

public class Clownfish extends Fish {

	public Clownfish() {
		super(Specialize.CLOWNFISH);
	}

	public void jokes(String joke) {
		AnimalBehaviour.consumer.accept(joke);
	}

}
