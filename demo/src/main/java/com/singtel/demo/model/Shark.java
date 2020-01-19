package com.singtel.demo.model;

import com.singtel.demo.util.SpecializeFish.Specialize;
import com.singtel.demo.util.Swimmable;

public class Shark extends Fish implements Swimmable {

	public Shark() {
		super(Specialize.SHARK);
	}

	public String eat() {
		return "Can eat other Fish";
	}

}
