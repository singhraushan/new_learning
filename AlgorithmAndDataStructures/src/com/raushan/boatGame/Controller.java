package com.raushan.boatGame;

import java.util.Scanner;
/**
 * @author Raushan kumar
 *
 */
public class Controller {
	private Vehicle vehicle;
	private static Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.vehicle = controller.buildBoat();
		controller.move();
	}

	public Vehicle buildBoat() {
		
		Position position = new Position(); 
		System.out.println("Please provide initial starting point(x,y) of the boat:");//assuming two integer value with comma separator. example: 15,2 
		String startingPoint = sc.next();
		position.setxPoint(Integer.parseInt(startingPoint.trim().split(",")[0]));
		position.setxPoint(Integer.parseInt(startingPoint.trim().split(",")[1]));
		System.out.println("Please provide initial facing direction of the boat:");//assuming one of the value from N,S,E,W. example: N 
		position.setDirection(sc.next().trim());
		position.setNoOfStepsToMove(1);
		return new Boat(position);
		
	}

	public void move() {
		
		String decider = "";
		do {
			System.out.println("Please provide command in proper format to move the boat:");//assuming string value with comma separator. ex: l,r,f,b
			String command = sc.next();
			vehicle.move(command.trim().replaceAll(",", "").toCharArray());
			printCurrentPosition();
			System.out.println("Do you want to move the boat again ?(Y/N) ");
			sc.next();
		} while (decider.equalsIgnoreCase("Y"));
	}
	public void printCurrentPosition() {
		System.out.println("current Position: "+vehicle.currentPosition().getxPoint()+","+vehicle.currentPosition().getyPoint());
	}
}

