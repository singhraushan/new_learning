package com.singtel.demo.model;

import org.junit.Assert;
import org.junit.Test;

import com.singtel.demo.util.Sound;

public class BirdTest {

	@Test
	public void shouldNotReturnNullCheck() {
		Bird bird = new Bird(true, true, true, Sound.BIRD_DEFAULT);
		Assert.assertNotNull(bird);
		Assert.assertTrue(bird.isSinging());
	}
	
	@Test
	public void roosterLanguageCheck() {
		Assert.assertNotNull("kukko kiekuu", Sound.BIRD_ROOSTER_FINNISH.getSound());
	}

}

