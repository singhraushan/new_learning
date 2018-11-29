/**
 * 
 */
package com.rau.draw;

/**
 * @author Raushan kumar
 *
 */
public class Triangle implements Shape {
	
	private String type;
	private int height;
	
	/**
	 * @param type
	 * @param height
	 */
	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}


	/**
	 * @param type
	 */
	public Triangle(String type) {
		this.type = type;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/* (non-Javadoc)
	 * @see com.rau.SingleTon_Spring_Hibernate_App.Shape#draw()
	 */
	@Override
	public void draw() {
		System.out.println("Drawing "+getType()+" Triangle Shape with height: "+height);
	}
}
