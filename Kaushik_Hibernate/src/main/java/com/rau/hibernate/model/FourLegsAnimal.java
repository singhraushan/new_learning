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
@DiscriminatorValue("FOUR_LEGS_ANIMAL")// not mandatory, just for specific value in Discriminator column 
public class FourLegsAnimal extends Animal{
	private boolean haveHorns;
	private String type;

	/**
	 * @return the haveHorns
	 */
	public boolean isHaveHorns() {
		return haveHorns;
	}

	/**
	 * @param haveHorns
	 *            the haveHorns to set
	 */
	public void setHaveHorns(boolean haveHorns) {
		this.haveHorns = haveHorns;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
