/**
 * 
 */
package com.rau.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Raushan kumar
 *
 */
@Entity
@Table(name = "OneToManyDemo_PERSON")
public class OneToManyDemoPerson {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // by default AUTO
	@Column(nullable = false, unique = true)
	private Integer personId;// int and Integer same

	private String personName;

	@OneToMany(mappedBy="person")
	private Collection<ManyToOneDemoVehicle> vehicle= new ArrayList<ManyToOneDemoVehicle>();

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
	public Collection<ManyToOneDemoVehicle> getVehicle() {
		return vehicle;
	}

	/**
	 * @param vehicle the vehicle to set
	 */
	public void setVehicle(Collection<ManyToOneDemoVehicle> vehicle) {
		this.vehicle = vehicle;
	}

	

}
