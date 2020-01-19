package com.singtel.demo.model;

import com.singtel.demo.util.SpecializeFish.Specialize;

public class Shark extends Fish {

	public Shark() {
		super(Specialize.SHARK);
	}

	public String eat() {
		return "Can eat other Fish";
	}

}
