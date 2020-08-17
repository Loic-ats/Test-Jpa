package appli;

import model.Livre;
import utils.DaoLivre;

public class AppliTestJpa {

	public static void main(String[] args) {

		DaoLivre d = new DaoLivre();

		// ------------------AJOUTER LIVRE-----------------

		Livre l1 = new Livre();

		// d.insertLivre(l1, 9, "Le livre de test", "Bob Eponge");;

		// ------------------MODIFIER LE TITRE D'UN LIVRE-----------------

		// d.updateTitre(8, "Le Chateaux de ma meres");
		
		// ------------------MODIFIER L'AUTEUR D'UN LIVRE-----------------

		
		// d.updateAuteur(8, "Marcel Pagnol");
		
		// ------------------SUPPRIMER UN LIVRE DE LA BDD-----------------

		// Méthode pour supprimer un livre

		//d.delateLivre(9);
		
		// ------------------AFFICHER LA LISTE DES LIVRES DE LA BDD-----------------

		d.listeLivres();
	}

}
