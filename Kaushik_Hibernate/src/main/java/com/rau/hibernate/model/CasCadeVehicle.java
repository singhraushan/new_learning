/**
 * 
 */
package com.rau.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Raushan kumar
 *
 */
@Entity(name = "PERSON_VEHICLE")
public class CasCadeVehicle {
	@Id
	@GeneratedValue
	private Integer vehicleId;
	private String vehicleName;
	
	@ManyToOne
	@JoinColumn(name = "PERSON_ID")
	private CascadePerson cascadePersonRef;
	
	
	/**
	 * @return the cascadePersonRef
	 */
	public CascadePerson getCascadePersonRef() {
		return cascadePersonRef;
	}

	/**
	 * @param cascadePersonRef the cascadePersonRef to set
	 */
	public void setCascadePersonRef(CascadePerson cascadePersonRef) {
		this.cascadePersonRef = cascadePersonRef;
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
