/**
 * 
 */
package com.rau.hibernate.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Raushan kumar
 *
 */
@Entity
@DiscriminatorValue("TWO_LEGS_ANIMAL")// not mandatory, just for specific value in Discriminator column 
public class TwoLegsAnimal extends Animal {
	private boolean haveTail;
	private String colour;

	/**
	 * @return the haveTail
	 */
	public boolean isHaveTail() {
		return haveTail;
	}

	/**
	 * @param haveTail
	 *            the haveTail to set
	 */
	public void setHaveTail(boolean haveTail) {
		this.haveTail = haveTail;
	}

	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}

	/**
	 * @param colour
	 *            the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

}
