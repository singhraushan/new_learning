/**
 * 
 */
package com.rau.hibernate.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Raushan kumar
 *
 */
@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	
	private int userId;
	
	private String userName;
	
	private static String description;//behave like @Transient 
	
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	
	
	private Address homeAddress;
	
	private Address officeAddress;


	/**
	 * @return the homeAddress
	 */
	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name="pin", column=@Column(name="HOME_PIN_CODE")),
	    @AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
	    @AttributeOverride(name="country", column=@Column(name="HOME_COUNTRY_NAME"))})
	public Address getHomeAddress() {
		return homeAddress;
	}

	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * @return the officeAddress
	 */
	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name="pin", column=@Column(name="OFFICE_PIN_CODE")),
	    @AttributeOverride(name="city", column=@Column(name="OFFICE_CITY_NAME")),
	    @AttributeOverride(name="country", column=@Column(name="OFFICE_COUNTRY_NAME"))})
	public Address getOfficeAddress() {
		return officeAddress;
	}

	/**
	 * @param officeAddress the officeAddress to set
	 */
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}

	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	/**
	 * @return the description
	 */
	public static String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public static void setDescription(String description) {
		UserDetails.description = description;
	}

	/**
	 * @return the userId
	 */
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */

	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = "using Setter "+userName;
	}

}
