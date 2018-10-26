/*
 * before handing over object to session object would be in transient state
 * After handing over object to session object & before closing the session, object would be in persistent state
 * After closing the session, object would be in detached state
*/
package com.rau.hibernate.manager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rau.hibernate.model.PersonStates;

/**
 * @author Raushan kumar
 *
 */

public class HibernateTransientPersistentDetachedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("HibernateCascadeTest : Main started");

		PersonStates person = new PersonStates();
		person.setPersonName("Amit");
		person.setPersonState("current Person state: transient");

		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx = session.getTransaction();
		tx.begin();

		person.setPersonState("current Person state: transient");
		session.save(person);
		person.setPersonState("current Person state: persistent");
		person.setPersonState("still current Person state: persistent");

		tx.commit();
		session.close();

		person.setPersonState("current Person state: detached");

		System.out.println("HibernateCascadeTest : Main ended");
	}

}
