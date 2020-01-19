package com.singtel.demo.model;

import com.singtel.demo.util.AnimalBehaviour;
import com.singtel.demo.util.Sound;

public class Bird extends Animal {

	private boolean isFlying;
	private boolean isSinging;

	public Bird(boolean isWalking, boolean isFlying, boolean isSinging, Sound sound) {
		super(isWalking);
		this.isFlying = isFlying;
		this.isSinging = isSinging;
		
		AnimalBehaviour.canFly(isFlying);
		sing(sound);
	}

	public boolean isFlying() {
		return isFlying;
	}

	public boolean isSinging() {
		return isSinging;
	}

	public void sing(Sound sound) {
		if (isSinging)
			AnimalBehaviour.consumer.accept(sound.getSound());
		else
			AnimalBehaviour.consumer.accept("Can't sing");
	}

}
