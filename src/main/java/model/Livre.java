package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Livre")

public class Livre {

	@Id
	private int id;
	
	@Column(name="TITRE", length= 255, nullable= false, unique = true)
	private String titre;
	
	@Column(name ="AUTEUR", length = 50, nullable = false, unique = true)
	private String auteur;
	
	@OneToMany(mappedBy = "livre")
	private List<Compo> listCompo;
	


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
	
	public List<Compo> getListCompo() {
		return listCompo;
	}

	public void setListCompo(List<Compo> listCompo) {
		this.listCompo = listCompo;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}

	
}