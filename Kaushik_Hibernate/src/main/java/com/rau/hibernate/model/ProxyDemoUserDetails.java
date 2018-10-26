/**
 * 
 */
package com.rau.hibernate.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

/**
 * @author Raushan kumar
 *
 */
@Entity
@Table(name="PROXY_USER_DETAILS")
public class ProxyDemoUserDetails {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private int userId;
		private String userName;
		
		@ElementCollection(fetch=FetchType.LAZY)//by default lazy i.e. no need to specify  //(fetch=FetchType.EAGER)
		@JoinTable(name="PROXY_USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))//this not needed but to give specific name and join column using this.
		private Collection<ProxyDemoAddress> address = new ArrayList<ProxyDemoAddress>();

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

		/**
		 * @return the address
		 */
		public Collection<ProxyDemoAddress> getAddress() {
			return address;
		}

		/**
		 * @param address the address to set
		 */
		public void setAddress(Collection<ProxyDemoAddress> address) {
			this.address = address;
		}
		
		
}
