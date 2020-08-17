package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Livre;

public class DaoLivre {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_essai");

	public void insertLivre(Livre livre, Integer id, String auteur, String titre) {

		// On créer un canal de communication em en utilisant la factory

		EntityManager em = factory.createEntityManager();

		// Si le canal de communication est différent de nul on peut ajouter un livre
		if (em != null) {
			
			livre.setId(id);
			livre.setAuteur(auteur);
			livre.setTitre(titre);

			// J'ouvre une transaction avec la BDD via mon EntityManager
			em.getTransaction().begin();

			// J'ajoute dans la base mon nouveau livre
			em.persist(livre);

			// Je commite et je ferme la transaction, le cannal de communication et la
			// factory

			em.getTransaction().commit();
			em.close();
			factory.close();

		}

	}

	public void updateTitre(Integer id, String newtitre) {

		// On créer un canal de communication em en utilisant la factory

		EntityManager em = factory.createEntityManager();

		// J'ouvre une transaction avec la BDD via mon EntityManager
		em.getTransaction().begin();

		// je recherche le livre via son id

		Livre l = em.find(Livre.class, id);

		l.setTitre(newtitre);

		// J'ajoute dans la base mon nouveau livre
		em.merge(l);

		// Je commite et je ferme la transaction, le cannal de communication et la
		// factory

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	public void updateAuteur(Integer id, String newauteur) {

		// On créer un canal de communication em en utilisant la factory

		EntityManager em = factory.createEntityManager();

		// J'ouvre une transaction avec la BDD via mon EntityManager
		em.getTransaction().begin();

		// je recherche le livre via son id

		Livre l = em.find(Livre.class, id);

		l.setAuteur(newauteur);

		// J'ajoute dans la base mon nouveau livre
		em.merge(l);

		// Je commite et je ferme la transaction, le cannal de communication et la
		// factory

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	public void delateLivre(Integer id) {

		// On créer un canal de communication em en utilisant la factory

		EntityManager em = factory.createEntityManager();

		// J'ouvre une transaction avec la BDD via mon EntityManager
		em.getTransaction().begin();

		// je recherche le livre via son id

		Livre l = em.find(Livre.class, id);

		// Je supprime livre de la BDD dans la base mon nouveau livre
		em.remove(l);

		// Je commite et je ferme la transaction, le cannal de communication et la
		// factory

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
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
			for (Livre l: q.getResultList()) {
				System.out.println(l);
			}
		}

		em.close();
		factory.close();
	}

}
