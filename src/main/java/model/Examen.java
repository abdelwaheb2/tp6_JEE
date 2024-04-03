package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 


@SuppressWarnings("serial")
@Entity 
@Table(name = "examen_tp6")
public class Examen implements Serializable{
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
private Long id;
private double note;
private String etudiant;
private double dure; 

@ManyToOne
@JoinColumn(name = "matieres")
private Matieres matieres; 

public Matieres getMatieres() {
	return matieres;
}
public void setMatieres(Matieres matieres) {
	this.matieres = matieres;
}
public Examen() {
super();
}
public Examen(Matieres matiere, double note, String etudiant, double dure) {
	super();
	this.setMatieres(matiere);
	this.note = note;
	this.etudiant = etudiant;
	this.dure = dure;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public double getNote() {
	return note;
}
public void setNote(double note) {
	this.note = note;
}
public String getEtudiant() {
	return etudiant;
}
public void setEtudiant(String etudiant) {
	this.etudiant = etudiant;
}
public double getDure() {
	return dure;
}
public void setDure(double dure) {
	this.dure = dure;
}

}