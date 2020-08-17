package jpa01;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import entity.Livre;

public class TestJpa {

	//Je créer un attribut de EntityManagerFactory "factory" par défault à null
	
private EntityManagerFactory factory = null;

	@Test
	public void test() {
		factory = Persistence.createEntityManagerFactory("pu_essai");
		
		EntityManager em = factory.createEntityManager();
		
		Livre livre1 = em.find(Livre.class, 1);
	}

}
