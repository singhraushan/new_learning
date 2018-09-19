package com.raushan.boatGame;
/**
 * @author Raushan kumar
 *
 */
public class Boat implements Vehicle {
	Position position;
	
	public Boat(Position startingPosition) {//setting starting position
		position = startingPosition;
	}
	
	@Override
	public void move(char[] direction) {
		for (char c : direction) {
            if(c == 'f') {
                moveFront();
            } else if (c == 'b') {
                moveBack();
            } else if (c == 'l') {
                turnLeft();
            } else {
                turnRight();
            }
        }
	}
	
	@Override
	public Position currentPosition() {
		 return deepClonePosition(position);
	}

	private Position deepClonePosition(Position position) {
		
		Position clonedObj = new Position();
		clonedObj.setxPoint(position.getxPoint());
		clonedObj.setyPoint(position.getyPoint());
		clonedObj.setDirection(position.getDirection());
        return clonedObj;
	}
	
	private void moveFront() {
		
		String direction = position.getDirection();
        if (direction.equalsIgnoreCase("N")) {
        	position.setyPoint(position.getyPoint()+position.getNoOfStepsToMove());
        } else if (direction.equalsIgnoreCase("S")) {
        	position.setyPoint(position.getyPoint()-position.getNoOfStepsToMove());
        } else if (direction.equalsIgnoreCase("E")) {
        	position.setxPoint(position.getxPoint()+position.getNoOfStepsToMove());
        } else {
        	position.setxPoint(position.getxPoint()-position.getNoOfStepsToMove());
        }
        
    }

	private void moveBack() {
		
		String direction = position.getDirection();
		if (direction.equalsIgnoreCase("N")) {
        	position.setyPoint(position.getyPoint()-position.getNoOfStepsToMove());
        } else if (direction.equalsIgnoreCase("S")) {
        	position.setyPoint(position.getyPoint()+position.getNoOfStepsToMove());
        } else if (direction.equalsIgnoreCase("E")) {
        	position.setxPoint(position.getxPoint()-position.getNoOfStepsToMove());
        } else {
        	position.setxPoint(position.getxPoint()+position.getNoOfStepsToMove());
        }
    }

    private void turnRight() {
    	String direction = position.getDirection();
        if (direction.equals("N")) {
        	position.setDirection("E");
        } else if (direction.equals("S")) {
        	position.setDirection("W");
        } else if (direction.equals("E")) {
            position.setDirection("S");
        } else {
        	position.setDirection("N");
        }
    }

    private void turnLeft() {
    	String direction = position.getDirection();
        if (direction.equals("N")) {
        	position.setDirection("W");
        } else if (direction.equals("S")) {
        	position.setDirection("E");
        } else if (direction.equals("E")) {
        	position.setDirection("N");
        } else {
        	position.setDirection("S");
        }
    }
}
