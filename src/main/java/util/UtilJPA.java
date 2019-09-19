package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {

	private static EntityManagerFactory factory;
	private static String persistenceUnitName = "persistence-unit-01";
	
	public static void createEntityManagerFactory() {
		if (factory == null)
			factory = Persistence.createEntityManagerFactory(persistenceUnitName);
	}
	
	public static EntityManager getEntityManager() {
		if (factory == null)
			createEntityManagerFactory();
		
		return factory.createEntityManager();
	}
	
	public static void closeEntityManagerFactory() {
		if (factory != null)
			factory.close();
	}
}
