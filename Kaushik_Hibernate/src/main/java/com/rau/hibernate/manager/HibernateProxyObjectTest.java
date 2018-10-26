/**
 * 
 */
package com.rau.hibernate.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rau.hibernate.model.ProxyDemoAddress;
import com.rau.hibernate.model.ProxyDemoUserDetails;

/**
 * @author Raushan kumar
 *
 */
public class HibernateProxyObjectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Main started:- ");
		
		ProxyDemoUserDetails userDetails = new ProxyDemoUserDetails();
		userDetails.setUserName("Raushan  kumar");
		
		ProxyDemoAddress address1 = new ProxyDemoAddress(); 
		address1.setPin("5496");
		address1.setCity("Patna");
		address1.setCountry("Singapore");
		
		ProxyDemoAddress address2 = new ProxyDemoAddress(); 
		address2.setPin("549126");
		address2.setCity("Bangalore");
		address2.setCountry("India");
		
		userDetails.getAddress().add(address1);
		userDetails.getAddress().add(address2);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		System.out.println("Main ended:- ");
		
		session = sf.openSession();
		ProxyDemoUserDetails proxyDemoUserDetails = session.get(ProxyDemoUserDetails.class, 1);
		
		session.close();//closing to test lazy testing
		System.out.println("If Lazy loading then LazyInitializationException because seeion closed: "+proxyDemoUserDetails.getAddress().size());
		
	}

}
