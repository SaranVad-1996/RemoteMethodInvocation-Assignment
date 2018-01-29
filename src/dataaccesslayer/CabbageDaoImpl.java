/* File: CabbageDaoImpl.java
 * Author: Saran Vadlamudi
 * Date: December 12, 2017
 * Description: Implements the methods in interface CabbageDao.java
 */
package dataaccesslayer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import datatransfer.Cabbage;

/* Note, enum for Singleton.
 */
public enum CabbageDaoImpl implements CabbageDao{
	INSTANCE; // only one for Singleton
	Configuration config = null;
	StandardServiceRegistryBuilder sRBuilder = null;
	ServiceRegistry sR = null;
	SessionFactory factory = null;
	Session s = null;
	Session s2 = null;
	
    /*
	 * The constructor will try to build a session factory
	 */
	private CabbageDaoImpl() {
		/* Tip: Make SessionFactory */
		System.out.println("Attempting to build SessionFactory");
		config = new Configuration()
		    .addAnnotatedClass(Cabbage.class) // load the entities
		    .configure();   // Tries to find hibernate configuration file for database connection properties
		
		sRBuilder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		sR = sRBuilder.build();
		factory = config.buildSessionFactory(sR);  // we create a factory only once per application
		System.out.println("SessionFactoryBuilt\n");
		
		System.out.println("Attempting to create and persist new entity");
			
	}
	
	/*
	 * This method will insert the supplied cabbage's information into the MySQL database
	 */
	@Override
    public void insert(Cabbage cabbage){
		s = factory.getCurrentSession();// we use factory to get a session whenever needed
		s.beginTransaction();	
		s.save(cabbage);// Cabbage object becomes persisten                                        
		s.getTransaction().commit();// Closes session                         
		System.out.println("new entity persisted\n");
	}
	
	/*
	 * Will find a specific cabbage object with the supplied UUID
	 */
	@Override
	public Cabbage findByUUID(String uuid){
		s2= factory.getCurrentSession();// creates a session
		s2.beginTransaction();// starts the transaction
		Query<Cabbage> query = s2.createQuery("FROM Cabbage WHERE uuid = :uuid", Cabbage.class);// Uses HQL to query to query a 
																						  // cabbage object with the where clause
		
		query.setParameter("uuid", uuid);// With the supplied uuid, setParamter will replace and embed the ":uuid" with the new value
		
		List<Cabbage> list = query.list();// query result will be stored as a cabbage object in list
		s2.getTransaction().commit();// Closes session 

		return list.get(0);// Since there will be always one cabbage object when querying by UUID,
						  // its safe to return the only cabbage object 
	}
}
