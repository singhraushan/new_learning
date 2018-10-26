/**
 * 
 */
package com.rau.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Raushan kumar
 *
 */
@Embeddable
public class Address {
	
	@Column(name="Pin_Code")
	private String pin;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="COUNTRY_NAME")
	private String country;
	
	/**
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	
}
