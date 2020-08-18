package modelbanque;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Client")

public class Client {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NOM", length = 50, nullable = false, unique = true)
	private String nom;

	@Column(name = "PRENOM", length = 50, nullable = false, unique = true)
	private String premnom;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATENAISSANCE", nullable = false, unique = true)
	private Date dateNaissance;
	
	@Embedded
	private Adresse adresseEmbedded;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

}
