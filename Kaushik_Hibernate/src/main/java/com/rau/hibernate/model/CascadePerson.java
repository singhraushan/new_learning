/**
 * 
 */
package com.rau.hibernate.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Raushan kumar
 *
 */
@Entity(name = "PERSON_TABLE")
public class CascadePerson {
	@Id
	@GeneratedValue
	private Integer id;

	private String personName;

	//@OneToMany(mappedBy = "cascadePersonRef",cascade = CascadeType.PERSIST) // persistCascadePerson
	//@OneToMany(mappedBy = "cascadePersonRef")  //getCascadePerson
	//@OneToMany(mappedBy = "cascadePersonRef",cascade = CascadeType.REMOVE) //deleteCascadePerson
	@OneToMany(mappedBy = "cascadePersonRef",cascade = CascadeType.MERGE) //mergeCascadePerson
	private Collection<CasCadeVehicle> casCadeVehicles;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the casCadeVehicles
	 */
	public Collection<CasCadeVehicle> getCasCadeVehicles() {
		return casCadeVehicles;
	}

	/**
	 * @param casCadeVehicles
	 *            the casCadeVehicles to set
	 */
	public void setCasCadeVehicles(Collection<CasCadeVehicle> casCadeVehicles) {
		this.casCadeVehicles = casCadeVehicles;
	}
}
