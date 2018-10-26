/**
 * 
 */
package com.rau.hibernate.manager;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rau.hibernate.model.Address;
import com.rau.hibernate.model.UserDetails;

/**
 * @author Raushan kumar
 *
 */
public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main started:- ");
		
		UserDetails userDetails = new UserDetails();
		//userDetails.setUserId(101);
		userDetails.setUserName("Raushan  kumar");
		userDetails.setDescription("desccccccccc");
		userDetails.setJoiningDate(new Date());
		
		Address homeAddress = new Address(); 
		homeAddress.setPin("5496");
		homeAddress.setCity("Patna");
		homeAddress.setCountry("Singapore");
		userDetails.setHomeAddress(homeAddress);
		
		Address officeAddress = new Address(); 
		officeAddress.setPin("549126");
		officeAddress.setCity("Bangalore");
		officeAddress.setCountry("India");
		userDetails.setOfficeAddress(officeAddress);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		System.out.println("----------");
		session = sf.openSession();
		UserDetails uDetails = session.get(UserDetails.class, 1);// pass class type & UserDetails.class, primary key ID.
		
		System.out.println("userName: "+uDetails.getUserName());
		System.out.println("Main ended:- ");
	}

}
