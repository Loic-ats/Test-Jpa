package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emprunt")

public class Emprunt {

	@Id
	private int id;

	@Column(name = "DATE_DEBUT", length = 50, nullable = false, unique = true)
	private Date date_debut;

	@Column(name = "DATE_FIN", length = 50, nullable = false, unique = true)
	private Date date_fin;
	
	@Column(name = "DELAI", length = 10, nullable = false, unique = true)
	private int delai;
	
	@Column(name = "ID_CLIENT", length = 10, nullable = false, unique = true)
	private int id_client;

	//Constructeur sans parametre de l'entity Emprunt
	public Emprunt() {
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", delai=" + delai
				+ ", id_client=" + id_client + "]";
	}

	
	
}
