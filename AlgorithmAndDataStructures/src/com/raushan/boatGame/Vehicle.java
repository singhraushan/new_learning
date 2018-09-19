package com.raushan.boatGame;
/**
 * @author Raushan kumar
 *
 */
public interface Vehicle {
	public void move(char[] direction);
	public Position currentPosition();
}
