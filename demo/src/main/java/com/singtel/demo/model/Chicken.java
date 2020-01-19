package com.singtel.demo.model;

import com.singtel.demo.util.Sound;

public class Chicken extends Bird{

	public Chicken(Sound sound) {
		super(true, false, true, sound);// I think duck can't fly
	}

}

