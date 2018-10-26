/**
 * 
 */
package com.rau.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Raushan kumar
 *
 */
@Entity
public class PersonStates {
	@Id
	@GeneratedValue
	private int personid;

	private String personName;
	
	private String personState;

	/**
	 * @return the personState
	 */
	public String getPersonState() {
		return personState;
	}

	/**
	 * @param personState the personState to set
	 */
	public void setPersonState(String personState) {
		this.personState = personState;
	}

	/**
	 * @return the personid
	 */
	public int getPersonid() {
		return personid;
	}

	/**
	 * @param personid
	 *            the personid to set
	 */
	public void setPersonid(int personid) {
		this.personid = personid;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName
	 *            the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

}
