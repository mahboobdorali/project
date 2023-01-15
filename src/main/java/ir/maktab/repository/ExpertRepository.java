package ir.maktab.repository;

import ir.maktab.madel.entity.Customer;
import ir.maktab.madel.entity.Expert;
import ir.maktab.repository.configuration.Config;

import javax.persistence.EntityManager;
import java.util.List;

public class ExpertRepository implements IRepository<Expert>{
    @Override
    public void save(Expert expert) {
            try {
                EntityManager em = Config.emf.createEntityManager();
                em.getTransaction().begin();
                em.persist(expert);
                em.getTransaction().commit();
                em.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
    }

    @Override
    public void update(Expert expert) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(expert);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Expert expert) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        Expert deleteExpert= em.find(Expert.class, expert.getId());
        em.remove(deleteExpert);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Expert> getAll() {
        EntityManager em =Config.emf.createEntityManager();
        em.getTransaction().begin();
        List<Expert> expertList = em.createNamedQuery("getAllExpert").getResultList();
        em.getTransaction().commit();
        em.close();
        return expertList;
    }
}
