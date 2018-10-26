/**
 * 
 */
package com.rau.hibernate.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rau.hibernate.model.SavingColletionDemoAddress;
import com.rau.hibernate.model.SavingColletionDemoUserDetails;

/**
 * @author Raushan kumar
 *
 */
public class HibernateSavingColletionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main started:- ");
		
		SavingColletionDemoUserDetails userDetails = new SavingColletionDemoUserDetails();
		userDetails.setUserName("Raushan  kumar");
		
		SavingColletionDemoAddress address1 = new SavingColletionDemoAddress(); 
		address1.setPin("5496");
		address1.setCity("Patna");
		address1.setCountry("Singapore");
		
		SavingColletionDemoAddress address2 = new SavingColletionDemoAddress(); 
		address2.setPin("549126");
		address2.setCity("Bangalore");
		address2.setCountry("India");
		
		userDetails.getListOfAddress().add(address1);
		userDetails.getListOfAddress().add(address2);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		System.out.println("Main ended:- ");
	}

}
