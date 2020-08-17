package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Livre")

public class Livre {

	@Id
	private Integer id;
	
	@Column(name="TITRE", length= 255, nullable= false, unique = true)
	private String titre;
	
	@Column(name ="AUTEUR", length = 50, nullable = false, unique = true)
	private String auteur;
	
	//Constructeur sans arguments pour l'entity "Livre"
	public Livre() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}