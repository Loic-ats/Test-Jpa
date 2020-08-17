package jpa01;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import model.Livre;

public class TestJpa {

	// Je créer un attribut de EntityManagerFactory "factory" par défault à null

	private EntityManagerFactory factory = null;

	@Before
	public void init() {
		// La classe Persistance du package javax contient les methodes pour créer
		// EntityManagerFactory
		// EntityManagerFactory permet de créer le canal de communication EntityManager
		factory = Persistence.createEntityManagerFactory("pu_essai");

	}

	@Test
	public void test() {

		// On créer un EntityManager via EntityManagerFactory " factory "
		// EntityManager est un canal de communication avec la base de donnée
		EntityManager em = factory.createEntityManager();

		// Si l'EntityManager fonctionne et a été créé différent de nul
		// On recherche via ce canal de communication l'entity livre ayant l'id = 1 et
		// on l'affiche via le system.out.println...
		if (em != null) {
			Livre livre1 = em.find(Livre.class, 1);
			System.out.println(livre1);

		}

		em.close();
		factory.close();
	}

	@Test
	public void listeLivres() {

		// On créer un EntityManager via EntityManagerFactory " factory "
		// EntityManager est un canal de communication avec la base de donnée

		EntityManager em = factory.createEntityManager();

		if (em != null) {

			// Si l'EntityManager fonctionne et a été créé différent de nul
			// On recherche via ce canal de communication l'ensemble des entity livre et on
			// les affiches via le system.out.println...

			String query = "SELECT l FROM Livre l";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for (Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}

		em.close();
		factory.close();
	}

	@Test
	public void listeLivresWhere() {

		// On créer un EntityManager via EntityManagerFactory " factory "
		// EntityManager est un canal de communication avec la base de donnée

		EntityManager em = factory.createEntityManager();

		if (em != null) {

			// Si l'EntityManager fonctionne et a été créé différent de nul
			// On recherche via ce canal de communication les entity livre qui ont un id
			// superieur à 3 et on les affiches via le system.out.println...

			//String query = "SELECT l FROM Livre l WHERE l.id >= 3";
			
			//On recherche les livre en fonction de leurs titre
			
			//String query = "SELECT l FROM Livre l WHERE l.titre = 'Germinal'";
			
			//On recherche les livre en fonction de son auteur
			
			String query = "SELECT l FROM Livre l WHERE l.auteur = 'Emile Zola'";
			
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for (Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}

		em.close();
		factory.close();
	}

	@Test
	public void insertLivre() {

		EntityManager em = factory.createEntityManager();

		if (em != null) {

			Livre l = new Livre();

			l.setId(7);
			l.setAuteur("Marc Humphrey");
			l.setTitre("Physique Quantique");

			// J'ouvre une transaction avec la BDD via mon EntityManager
			em.getTransaction().begin();

			// J'ajoute dans la base mon nouveau livre
			em.persist(l);

			// Je commite et je ferme la transaction, le cannal de communication et la
			// factory

			em.getTransaction().commit();
			em.close();
			factory.close();

		}

	}

	@Test
	public void updateLivre() {

		EntityManager em = factory.createEntityManager();

		// J'ouvre une transaction avec la BDD via mon EntityManager
		em.getTransaction().begin();
		// je Cherche le livre avec l'ID 5 et je change son titre par les orientales
		Livre l = em.find(Livre.class, 5);
		l.setTitre("Du plaisir dans la cuisine");

		// J'ajoute dans la base mon nouveau livre
		em.merge(l);

		// Je commite et je ferme la transaction, le cannal de communication et la
		// factory

		em.getTransaction().commit();
		em.close();
		factory.close();

	}

	@Test
	public void delateLivre() {

		EntityManager em = factory.createEntityManager();

		// J'ouvre une transaction avec la BDD via mon EntityManager
		em.getTransaction().begin();

		// je Cherche le livre avec l'ID 6 et je change son titre par les orientales
		Livre l = em.find(Livre.class, 6);

		// Je supprime livre de la BDD dans la base mon nouveau livre
		em.remove(l);

		// Je commite et je ferme la transaction, le cannal de communication et la
		// factory

		em.getTransaction().commit();
		em.close();
		factory.close();

	}

}
