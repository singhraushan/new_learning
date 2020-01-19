package com.singtel.demo.model;

import com.singtel.demo.util.Sound;


//It's same as chicken, only differences are it can fly and speak differently.  
public class Rooster {

	private String sing;
	private Bird bird;
	
	public Rooster(Sound sound){
		bird = new Bird(true, true, true, sound);
	}
	
	public String getSing() {
		return sing;
	}

	public Bird getBird() {
		return bird;
	}
	
}
