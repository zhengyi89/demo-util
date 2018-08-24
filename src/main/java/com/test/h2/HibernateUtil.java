package com.test.h2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	  private static final SessionFactory sessionFactory = buildSessionFactory();
	  
	    private static SessionFactory buildSessionFactory() {
	    	SessionFactory sessionFactory;
	    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	    			.configure("hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
	    			.build();
	    	try {
	    		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	    		return sessionFactory;
	    	}
	    	catch (Exception e) {
	    		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
	    		// so destroy it manually.
	    		e.printStackTrace();
	    		StandardServiceRegistryBuilder.destroy( registry );
	    	}
			return null;
	    }
	 
	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }
}
