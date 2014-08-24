package com.github.nioto.snippets;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	Company company = new Company();
    	company.setName("Acme Inc.");
    	
    	EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction()
            .begin();
        em.persist(company);
        em.getTransaction()
            .commit();
     
        Query q = em.createQuery("select count(*) from Company c");
        System.out.println( q.getSingleResult() );
        em.close();
        PersistenceManager.INSTANCE.close();    }
}
