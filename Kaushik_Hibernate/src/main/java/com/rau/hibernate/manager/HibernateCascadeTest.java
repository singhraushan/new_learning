package com.rau.hibernate.manager;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rau.hibernate.model.CasCadeVehicle;
import com.rau.hibernate.model.CascadePerson;

/**
 * @author Raushan kumar
 *
 */
public class HibernateCascadeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("HibernateCascadeTest : Main started");
		 //persistCascadePerson();
		 //getCascadePerson();
		 //removeCascadePerson();
		mergeCascadePerson();
		System.out.println("HibernateCascadeTest : Main ended");
	}

	public static void persistCascadePerson() {
		System.out.println("HibernateCascadeTest : persistCascadePerson started");

		CascadePerson cascadePerson = new CascadePerson();
		cascadePerson.setPersonName("Amit");

		Collection<CasCadeVehicle> casCadeVehicleList = new ArrayList<CasCadeVehicle>();

		CasCadeVehicle casCadeVehicle1 = new CasCadeVehicle();
		casCadeVehicle1.setVehicleName("Car");
		casCadeVehicle1.setCascadePersonRef(cascadePerson);
		CasCadeVehicle casCadeVehicle2 = new CasCadeVehicle();
		casCadeVehicle2.setVehicleName("Bike");
		casCadeVehicle2.setCascadePersonRef(cascadePerson);
		CasCadeVehicle casCadeVehicle3 = new CasCadeVehicle();
		casCadeVehicle3.setVehicleName("Cycle");
		casCadeVehicle3.setCascadePersonRef(cascadePerson);

		casCadeVehicleList.add(casCadeVehicle1);
		casCadeVehicleList.add(casCadeVehicle2);
		casCadeVehicleList.add(casCadeVehicle3);

		cascadePerson.setCasCadeVehicles(casCadeVehicleList);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		session.getTransaction().begin();
		session.persist(cascadePerson);
		session.getTransaction().commit();
		session.close();

		System.out.println("HibernateCascadeTest persistCascadePerson Over");
	}

	public static void getCascadePerson() {
		System.out.println("HibernateCascadeTest : getCascadePerson started");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		CascadePerson cascadePerson = session.get(CascadePerson.class, 1);
		session.close();
		System.out.println("cascadePerson.getPersonName: " + cascadePerson.getPersonName());
		System.out.println("cascadePerson.getCasCadeVehicles().size(): " + cascadePerson.getCasCadeVehicles().size());

		System.out.println("HibernateCascadeTest getCascadePerson Over");
	}

	public static void removeCascadePerson() {
		System.out.println("HibernateCascadeTest : removeCascadePerson started");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		CascadePerson cascadePerson = session.get(CascadePerson.class, 1);

		session.getTransaction().begin();
		session.remove(cascadePerson);

		session.getTransaction().commit();

		System.out.println("HibernateCascadeTest removeCascadePerson Over");
	}
	
	public static void mergeCascadePerson() {
		System.out.println("HibernateCascadeTest : mergeCascadePerson started");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		CascadePerson cascadePerson = session.get(CascadePerson.class, 5);

		cascadePerson.setPersonName("Alok6");
		cascadePerson.getCasCadeVehicles().iterator().next().setVehicleName("Updated Vehicle6");
		
		session.getTransaction().begin();
		session.merge(cascadePerson);

		session.getTransaction().commit();

		System.out.println("HibernateCascadeTest mergeCascadePerson Over");
	}
	
}
