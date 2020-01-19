package com.singtel.demo.model;

import com.singtel.demo.util.AnimalBehaviour;

public class Animal {

	private boolean isWalking;

	public Animal(boolean isWalking) {
		this.isWalking = isWalking;
		AnimalBehaviour.canWalk(isWalking);
	}

	public boolean isWalking() {
		return isWalking;
	}

}
