package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Examen;
import util.JpaUtil;

public class Examen_Impl implements Iexamen {
private EntityManager entityManager=JpaUtil.getEntityManager("examan_tp6_JEE");
@Override
public Examen save(Examen p) {
	EntityTransaction tx = entityManager.getTransaction();
	tx.begin();
	entityManager.persist(p);
	tx.commit();
	return p;
}
@Override
public List<Examen> ExamensParMC(String mc) {
List<Examen> prods = entityManager.createQuery("select e from Examen e where e.etudiant like :mc or e.matieres.id in ( select m.id from Matieres m  where m.labelle like :mc)").setParameter("mc", "%"+mc+"%").getResultList();

return prods;
}
@Override
public Examen getExamen(Long id) {
return entityManager.find(Examen.class, id);
}
@Override
public Examen updateExamen(Examen p) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(p);
tx.commit();
return p;
}
@Override
public void deleteExamen(Long id) {
Examen Examen = entityManager.find(Examen.class, id);
entityManager.getTransaction().begin();
entityManager.remove(Examen);
entityManager.getTransaction().commit();
}}