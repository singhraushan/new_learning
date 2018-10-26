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
public class CRUDPerson {
	@Id
	@GeneratedValue
	private int personid;

	private String personName;

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
