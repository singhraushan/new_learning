package com.rau.hibernate.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rau.hibernate.model.ManyToOneDemoVehicle;
import com.rau.hibernate.model.OneToManyDemoPerson;

/**
 * @author Raushan kumar
 *
 */
public class HibernateOneToManyMappingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main started");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		OneToManyDemoPerson person = new OneToManyDemoPerson();
		person.setPersonName("Amit");

		ManyToOneDemoVehicle vehicle = new ManyToOneDemoVehicle();
		vehicle.setVehicleName("Car");
		
		person.getVehicle().add(vehicle);
		vehicle.setPerson(person);

		session.getTransaction().begin();
		session.save(person);
		session.save(vehicle);
		session.getTransaction().commit();

		System.out.println("Main Over");
	}

}
