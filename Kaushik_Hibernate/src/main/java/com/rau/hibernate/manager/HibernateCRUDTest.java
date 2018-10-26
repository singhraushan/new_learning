/**
 * 
 */
package com.rau.hibernate.manager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rau.hibernate.model.CRUDPerson;

/**
 * @author Raushan kumar
 *
 */
public class HibernateCRUDTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("HibernateCascadeTest : Main started");
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		CRUDPerson person = null;
		
		Transaction tx = session.getTransaction();
		tx.begin();
		
		//create
		for (int i=1;i<=10 ;i++) {
			person = new CRUDPerson();
			person.setPersonName("Person "+i);
			session.save(person);
		}
		
		tx.commit();
		
		//read
		person = session.get(CRUDPerson.class, 6);
		
		//update
		tx.begin();//since after commit session not active so beginning again
		person.setPersonName("Updated person 6");
		session.update(person);
		tx.commit();
		
		
		//delete
		tx.begin();//since after commit session not active so beginning again
		person = session.get(CRUDPerson.class, 6);
		session.delete(person);
		tx.commit();
				
		
		session.close();
		
		System.out.println("HibernateCascadeTest : Main ended");
	}

}
