package com.rau.hibernate.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rau.hibernate.model.ManyToManyDemoPerson;
import com.rau.hibernate.model.ManyToManyDemoVehicle;

/**
 * @author Raushan kumar
 *
 */
public class HibernateManyToManyMappingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Main started");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		ManyToManyDemoPerson person = new ManyToManyDemoPerson();
		person.setPersonName("Amit");

		ManyToManyDemoVehicle vehicle = new ManyToManyDemoVehicle();
		vehicle.setVehicleName("Car");
		
		ManyToManyDemoVehicle vehicle2 = new ManyToManyDemoVehicle();
		vehicle2.setVehicleName("Bus");
		
		person.getVehicles().add(vehicle);
		person.getVehicles().add(vehicle2);
		
		vehicle.getPersons().add(person);
		vehicle2.getPersons().add(person);

		session.getTransaction().begin();
		session.save(person);
		session.save(vehicle);
		session.save(vehicle2);
		session.getTransaction().commit();

		System.out.println("Main Over");
	}

}

