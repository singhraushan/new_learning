package com.singtel.demo.model;

import com.singtel.demo.util.AnimalBehaviour;

public class Butterfly extends Animal {
	public Butterfly() {
		super(false);
		AnimalBehaviour.canFly(true);
	}

	public boolean isFlying() {
		return true;
	}
}
