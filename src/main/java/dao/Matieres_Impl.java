package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Matieres;
import util.JpaUtil;

public class Matieres_Impl implements Imatieres {
private EntityManager entityManager=JpaUtil.getEntityManager("examan_tp6_JEE");
@Override
public Matieres save(Matieres mat ) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(mat);
tx.commit();
return mat;
}
@Override
public Matieres getmatiere(Long id) {
return entityManager.find(Matieres.class, id);
}
@Override
public Matieres updatematiere(Matieres mat) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(mat);
tx.commit();
return mat;
}
@Override
public void deletematiere(Long id) {
Matieres Matieres = entityManager.find(Matieres.class, id);
entityManager.getTransaction().begin();
entityManager.remove(Matieres);
entityManager.getTransaction().commit();
}
@Override
public List<Matieres> getAll() {
List<Matieres> mats = entityManager.createQuery("select c from Matieres c").getResultList();
return mats;
}
}