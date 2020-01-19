package com.singtel.demo.util;

import java.util.function.Consumer;

public interface AnimalBehaviour {

	Consumer<String> consumer = s -> System.out.println(s);

	static void canWalk(boolean isWalkable) {
		consumer.accept(isWalkable ? "I am walking" : "I can't walk");
	}

	static void canFly(boolean isFlying) {
		consumer.accept(isFlying ? "I am Flying" : "I can't Fly");
	}

}
