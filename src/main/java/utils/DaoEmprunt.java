package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Compo;
import model.Emprunt;

public class DaoEmprunt {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_essai");

	public void listeLivresEmprunt(Integer id) {

		EntityManager em = factory.createEntityManager();

		if (em != null) {

			String query = "SELECT e FROM Compo e WHERE e.empruntC.id = :param1";

			TypedQuery<Compo> q = em.createQuery(query, Compo.class);
			q.setParameter("param1", id);
			for (Compo c : q.getResultList()) {
				System.out.println(c.getLivre());

			}
		}

		em.close();
		factory.close();
	}

	public void listeEmpruntClient(Integer id) {

		EntityManager em = factory.createEntityManager();

		if (em != null) {

			String query = "SELECT e FROM Emprunt e WHERE e.id_client.id = :param1";

			TypedQuery<Emprunt> q = em.createQuery(query, Emprunt.class);
			q.setParameter("param1", id);
			for (Emprunt e : q.getResultList()) {
				System.out.println(e);
			}
		}

		em.close();
		factory.close();
	}

}
