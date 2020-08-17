package jpa01;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import entity.Livre;

public class TestJpa {

	//Je cr�er un attribut de EntityManagerFactory "factory" par d�fault � null
	
private EntityManagerFactory factory = null;

	@Test
	public void test() {
		factory = Persistence.createEntityManagerFactory("pu_essai");
		
		EntityManager em = factory.createEntityManager();
		
		Livre livre1 = em.find(Livre.class, 1);
	}

}
