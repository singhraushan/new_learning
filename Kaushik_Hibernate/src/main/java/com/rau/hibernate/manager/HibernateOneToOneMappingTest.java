/**
 * 
 */
package com.rau.hibernate.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rau.hibernate.model.Person;
import com.rau.hibernate.model.Vehicle;

/**
 * @author Raushan kumar
 *
 */
public class HibernateOneToOneMappingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main started");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		Person person = new Person();
		person.setPersonName("Amit");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		person.setVehicle(vehicle);

		session.getTransaction().begin();
		session.save(person);
		session.save(vehicle);
		session.getTransaction().commit();

		session.close();

		System.out.println("Main Over");
	}

}
