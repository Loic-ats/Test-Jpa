package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Emprunt")

public class Emprunt {

	@Id
	private int id;

	// Pour traduire en modèle objet des dates on utilise l'annotation @Temporal ==>
	// TIMESTAMP (Heure + date), DATE (Date), TIME (Time);
	// nullable false ==> Not Null, true ==> Null (peu etre nul)

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_DEBUT", nullable = false, unique = true)
	private Date date_debut;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_FIN", nullable = true, unique = true)
	private Date date_fin;

	@Column(name = "DELAI", length = 10, nullable = true, unique = true)
	private int delai;

	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT", nullable = false, unique = true)
	private Client id_client;

	// Un emprunt peut avoir 1 seul client
	// La table de jointure est la table COMPO

	@OneToMany(mappedBy = "empruntC")
	private List<Compo> listCompo;

	// Constructeur sans parametre de l'entity Emprunt
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

	public Client getId_client() {
		return id_client;
	}

	public void setId_client(Client id_client) {
		this.id_client = id_client;
	}

	public List<Compo> getListCompo() {
		return listCompo;
	}

	public void setListCompo(List<Compo> listCompo) {
		this.listCompo = listCompo;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", delai=" + delai
				+ ", id_client=" + id_client + "]";
	}

}
