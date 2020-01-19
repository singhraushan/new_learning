package com.singtel.demo.util;

public enum Sound {
	
	BIRD_DUCK("Quack, quack"),
	BIRD_CHICKEN("Cluck, cluck"),
	
	BIRD_ROOSTER_DANISH("kykyliky"), 
	BIRD_ROOSTER_DUTCH("kukeleku"), 
	BIRD_ROOSTER_FINNISH("kukko kiekuu"), 
	BIRD_ROOSTER_FRENCH("cocorico"), 
	BIRD_ROOSTER_GERMAN("kikeriki"), 
	BIRD_ROOSTER_GREEK("kikiriki"), 
	BIRD_ROOSTER_HEBREW("coo-koo-ri-koo"), 
	BIRD_ROOSTER_HUNGARIAN("kukuriku"), 
	BIRD_ROOSTER_ITALIAN("chicchirichi"), 
	BIRD_ROOSTER_JAPANESE("ko-ke-kok-ko-o"), 
	BIRD_ROOSTER_PORTUGUESE("cucurucu"), 
	BIRD_ROOSTER_RUSSIAN("kukareku"), 
	BIRD_ROOSTER_SWEDISH("kuckeliku"), 
	BIRD_ROOSTER_TURKISH("kuk-kurri-kuuu"),
	BIRD_ROOSTER_URDU("kuklooku"),
	BIRD_DEFAULT("Cock-a-doodle-doo"),
	
	BIRD_PARROT_LIVING_WITH_DOG("Woof, woof"),
	BIRD_PARROT_LIVING_WITH_CAT("Meow"),
	BIRD_PARROT_LIVING_WITH_ROOSTER("Cock-a-doodle-doo");

	private String sound;

	Sound(String sound) {
		this.sound = sound;
	}

	public String getSound() {
		return sound;
	}
}
