package web;
import java.util.ArrayList;
import java.util.List;
import model.Matieres;

public class Matieremodel {
	
	private List<Matieres> mat = new ArrayList<>();
	public List<Matieres> getMatieres() {
	return mat;
	}
	public void setMatieres(List<Matieres> m) {
	this.mat = m;
	}
	
	public List<Matieres> getMat(){
		return mat;
	}
	
}
