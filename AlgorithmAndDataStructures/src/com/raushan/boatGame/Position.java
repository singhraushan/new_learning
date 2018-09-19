package com.raushan.boatGame;
/**
 * @author Raushan kumar
 *
 */
public class Position {
   private int xPoint;
   private int yPoint;
   private String direction;
   private int noOfStepsToMove;
 
	public int getxPoint() {
		return xPoint;
	}
	public void setxPoint(int xPoint) {
		this.xPoint = xPoint;
	}
	public int getyPoint() {
		return yPoint;
	}
	public void setyPoint(int yPoint) {
		this.yPoint = yPoint;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getNoOfStepsToMove() {
		return noOfStepsToMove;
	}
	public void setNoOfStepsToMove(int noOfStepsToMove) {
		this.noOfStepsToMove = noOfStepsToMove;
	}	
}
