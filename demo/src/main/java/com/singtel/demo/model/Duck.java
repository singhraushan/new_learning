package com.singtel.demo.model;

import com.singtel.demo.util.Sound;
import com.singtel.demo.util.Swimmable;

public class Duck extends Bird implements Swimmable{

	public Duck(Sound sound) {
		super(true, true, true, sound);// I think duck can fly
	}

}
