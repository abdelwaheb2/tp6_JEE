package dao;

import java.util.List;
import model.Matieres;
public interface Imatieres {
public Matieres save(Matieres cat);
public Matieres getmatiere(Long id);
public Matieres updatematiere(Matieres cat);
public void deletematiere(Long id);
public List<Matieres> getAll();
}