/**
 * 
 */
package com.rau.hibernate.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rau.hibernate.model.Animal;
import com.rau.hibernate.model.FourLegsAnimal;
import com.rau.hibernate.model.TwoLegsAnimal;

/**
 * @author Raushan kumar
 *
 */
public class HibernateInheritanceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("HibernateInheritanceTest : main started");

		Animal animal = new Animal();		
		animal.setName("sally");

		FourLegsAnimal fourLegsAnimal = new FourLegsAnimal();
		fourLegsAnimal.setHaveHorns(true);
		fourLegsAnimal.setType("cow");
		
		TwoLegsAnimal twoLegsAnimal = new TwoLegsAnimal();
		twoLegsAnimal.setColour("white");
		twoLegsAnimal.setHaveTail(true);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.getTransaction();
		tx.begin();
		session.save(animal);
		session.save(fourLegsAnimal);
		session.save(twoLegsAnimal);
		tx.commit();
		session.close();

		System.out.println("HibernateInheritanceTest main Over");
	}	
}
