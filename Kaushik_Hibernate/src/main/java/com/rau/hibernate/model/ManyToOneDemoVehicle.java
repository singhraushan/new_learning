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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Raushan kumar
 *
 */
@Entity
@Table(name = "ManyToOneDemo_PERSON_VEHICLE")
public class ManyToOneDemoVehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // by default AUTO
	@Column(nullable = false, unique = true)
	private Integer vehicleId;// int and Integer same
	private String vehicleName;
	
	@ManyToOne
	@JoinColumn(name = "person_Id")
	private OneToManyDemoPerson person;


	/**
	 * @return the persons
	 */
	public OneToManyDemoPerson getPerson() {
		return person;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPerson(OneToManyDemoPerson person) {
		this.person = person;
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
