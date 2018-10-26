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
@Table(name = "ManyToManyDemo_PERSON_VEHICLE")
public class ManyToManyDemoVehicle {
	@Id
	@GeneratedValue
	private Integer vehicleId;

	private String vehicleName;

	@ManyToMany
	private Collection<ManyToManyDemoPerson> persons = new ArrayList<ManyToManyDemoPerson>();

	/**
	 * @return the persons
	 */
	public Collection<ManyToManyDemoPerson> getPersons() {
		return persons;
	}

	/**
	 * @param persons
	 *            the persons to set
	 */
	public void setPersons(Collection<ManyToManyDemoPerson> persons) {
		this.persons = persons;
	}

	/**
	 * @return the vehicleId
	 */
	public Integer getVehicleId() {
		return vehicleId;
	}

	/**
	 * @param vehicleId
	 *            the vehicleId to set
	 */
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * @return the vehicleName
	 */
	public String getVehicleName() {
		return vehicleName;
	}

	/**
	 * @param vehicleName
	 *            the vehicleName to set
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
