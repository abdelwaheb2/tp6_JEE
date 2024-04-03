package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;

@Entity
public class Matieres implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private Double coffetion;

	private String labelle;
	
	@OneToMany (mappedBy="matieres")
	private List<Examen> examens;

	public Matieres( Double coffetion, String labelle) {
		super();
		this.coffetion = coffetion;
		this.labelle = labelle;
	}

	public Matieres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Examen> getExamens() {
		return examens;
	}

	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCoffetion() {
		return this.coffetion;
	}

	public void setCoffetion(Double coffetion) {
		this.coffetion = coffetion;
	}

	public String getLabelle() {
		return this.labelle;
	}

	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}

}