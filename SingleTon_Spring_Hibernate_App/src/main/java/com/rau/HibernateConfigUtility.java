/**
 * 
 */
package com.rau;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Raushan kumar
 *
 */
public class HibernateConfigUtility {
  static {
	  Configuration configuration = new Configuration();

      //Create Properties, can be read from property files too
      Properties props = new Properties();
      props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
      props.put("hibernate.connection.url", "jdbc:mysql://localhost/Book");
      props.put("hibernate.connection.username", "root");
      props.put("hibernate.connection.password", "");
      props.put("hibernate.current_session_context_class", "thread");

      configuration.setProperties(props);

      //we can set mapping file or class with annotation
      //addClass(Employee1.class) will look for resource
      // com/journaldev/hibernate/model/Employee1.hbm.xml (not good)
      //configuration.addAnnotatedClass(Book1.class);

      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
      System.out.println("Hibernate Java Config serviceRegistry created");

      SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

  }
}
