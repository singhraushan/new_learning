/**
 * 
 */
package com.rau.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Raushan kumar
 *
 */
@Entity
@Table(name = "ManyToManyDemo_PERSON")
public class ManyToManyDemoPerson {
	@Id
	@GeneratedValue
	private Integer personId;

	private String personName;

	@ManyToMany(mappedBy = "persons")
	private Collection<ManyToManyDemoVehicle> vehicles = new ArrayList<ManyToManyDemoVehicle>();

	/**
	 * @return the vehicles
	 */
	public Collection<ManyToManyDemoVehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles
	 *            the vehicles to set
	 */
	public void setVehicles(Collection<ManyToManyDemoVehicle> vehicles) {
		this.vehicles = vehicles;
	}

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

}
