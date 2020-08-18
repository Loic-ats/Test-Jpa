package modelbanque;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	/**
	 * On créer une classe adresse @Embeddable dans laquelle il y a tous les paramettre de l'adresse que l'on va utilisé pour client
	 * Respecter le nom et le type des colonnes il faut que ce soit en cohérence
	 * avec la BDD physique
	 * 
	 */

	private int numero;
	private String rue;
	private int codepostal;
	private String ville;

	// Constructeur sans argument de adresse
	public Adresse() {

	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", rue=" + rue + ", codepostal=" + codepostal + ", ville=" + ville + "]";
	}

}
