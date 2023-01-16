package ir.maktab.repository;

import ir.maktab.madel.entity.Customer;
import ir.maktab.madel.entity.Expert;
import ir.maktab.repository.configuration.Config;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class ExpertRepository implements IRepository<Expert> {
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
        Expert deleteExpert = em.find(Expert.class, expert.getId());
        em.remove(deleteExpert);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Expert> getAll() {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        List<Expert> expertList = em.createNamedQuery("getAllExpert").getResultList();
        em.getTransaction().commit();
        em.close();
        return expertList;
    }

    public Optional<Expert> getByEmail(String emailAddress) {
        Expert expert;
        try {
            EntityManager em = Config.emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("from Expert e where e.emailAddress =:emailAddress");
            query.setParameter("emailAddress", emailAddress);
            expert = (Expert) query.getSingleResult();
            em.getTransaction().commit();
            em.close();
        } catch (NoResultException e) {
            expert = null;
        }
        return Optional.ofNullable(expert);
    }

//    public Optional<Expert> findEmailAddress(String email) {
//        EntityManager em = Config.emf.createEntityManager();
//        Expert expert;
//        try {
//            em.getTransaction().begin();
//            expert = em.find(Expert.class, email);
//            em.getTransaction().commit();
//        } catch (NoResultException e) {
//            expert = null;
//        }
//        return Optional.ofNullable(expert);
//    }

    public Expert updatePasswordByEmailAddress(String password, String emailAddress) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("update Expert e set e.password=:password" +
                " where e.emailAddress=:emailAddress");
        query.setParameter("password", password);
        query.setParameter("emailAddress", emailAddress);
        query.executeUpdate();
        Expert expert = (Expert) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return expert;
    }
}
