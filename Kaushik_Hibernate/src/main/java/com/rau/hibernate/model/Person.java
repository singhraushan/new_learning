/**
 * 
 */
package com.rau.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Raushan kumar
 *
 */
@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // by default AUTO
	@Column(nullable = false, unique = true)
	private Integer personId;// int and Integer same

	private String personName;

	@OneToOne
	@JoinColumn(name = "VEHICLE_ID") // VEHICLE_ID is joining column in
										// person(currentŌ) table.
	private Vehicle vehicle;

	/**
	 * @return the personId
	 */
	public Integer getPersonId() {
		return personId;
	}

	/**
	 * @param personId
	 *            the personId to set
	 */
	public void setPersonId(Integer personId) {
		this.personId = personId;
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

	/**
	 * @return the vehicle
	 */
	public Vehicle getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle
	 *            the vehicle to set
	 */
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
