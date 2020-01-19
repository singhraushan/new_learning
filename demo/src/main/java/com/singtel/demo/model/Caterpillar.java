package com.singtel.demo.model;

import com.singtel.demo.util.AnimalBehaviour;

public class Caterpillar extends Animal{

	public Caterpillar(boolean isWalking) {
		super(true);
		AnimalBehaviour.canFly(false);
	}

	Butterfly metamorphosis() {
		return new Butterfly();
	}
}
