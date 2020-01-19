package com.singtel.demo.model;

import com.singtel.demo.util.SpecializeFish.Specialize;
import com.singtel.demo.util.Swimmable;

public class Fish extends Animal implements Swimmable{

	private boolean isFlying = false;
	private boolean isSinging = false;
	Specialize f;

	public Fish(Specialize specialize) {
		super(false);
		f = specialize;
	}

	public boolean isFlying() {
		return isFlying;
	}

	public boolean isSinging() {
		return isSinging;
	}

	public String getColour() {
		return f.getColour();
	}

	public String getSize() {
		return f.getSize();
	}

}
