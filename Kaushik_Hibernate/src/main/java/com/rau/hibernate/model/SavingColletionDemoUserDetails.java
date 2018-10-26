/**
 * 
 */
package com.rau.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author Raushan kumar
 *
 */
@Entity
@Table(name="COLLECTIONDEMO_USER")
public class SavingColletionDemoUserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@ElementCollection
	@JoinTable(name="COLLECTIONDEMO_USER_ADDRESS", joinColumns = @JoinColumn(name="USER_ID"))//this is for specific name of table & joining cloumn f you want
	@GenericGenerator(name="increment-gen", strategy="increment")//creating increment sequence to use in @CollectionId
	@CollectionId(columns={@Column(name="ADDRESS_ID")},generator="increment-gen",type=@Type(type="long"))//this is for PK column if you want in address table. @CollectionId support only List
	private Collection<SavingColletionDemoAddress> listOfAddress = new ArrayList<SavingColletionDemoAddress>();
	
	//below also work same as above only thing specifying the table name & joining column name. 
	/*@ElementCollection
	private Set<Address> listOfAddress = new HashSet<Address>();
	*/
	
	/**
	 * @return the listOfAddress
	 */
	public Collection<SavingColletionDemoAddress> getListOfAddress() {
		return listOfAddress;
	}
	/**
	 * @param listOfAddress the listOfAddress to set
	 */
	public void setListOfAddress(Collection<SavingColletionDemoAddress> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
