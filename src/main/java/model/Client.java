package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Client")

public class Client {

	@Id
	private int id;

	@Column(name = "NOM", length = 50, nullable = false, unique = true)
	private String nom;

	@Column(name = "PRENOM", length = 50, nullable = false, unique = true)
	private String premnom;
	
	//Constructeur sans argument de l'entity client
	public Client() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPremnom() {
		return premnom;
	}

	public void setPremnom(String premnom) {
		this.premnom = premnom;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", premnom=" + premnom + "]";
	}

	
}
