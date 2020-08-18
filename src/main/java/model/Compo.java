package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Compo")

public class Compo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "ID_LIV")
	private Livre livre;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name = "ID_EMP")
	private Emprunt empruntC;
	
	// Constructeur sans argument de la table Compo
	public Compo() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Emprunt getEmprunt() {
		return empruntC;
	}

	public void setEmprunt(Emprunt emprunt) {
		this.empruntC = emprunt;
	}

	@Override
	public String toString() {
		return "Compo [id=" + id + ", livre=" + livre + ", emprunt=" + empruntC + "]";
	}
	
}
