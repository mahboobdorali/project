package ir.maktab.repository;

import ir.maktab.madel.entity.Service;
import ir.maktab.madel.entity.UnderService;
import ir.maktab.repository.configuration.Config;

import javax.persistence.EntityManager;
import java.util.List;

public class UnderServiceRepository implements IRepository<UnderService>{
    @Override
    public void save(UnderService underService) {
        try {
            EntityManager em = Config.emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(underService);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    //هروقت خواستم سیوش کنم توی سرویس اول شرط is existرو میزنم ک اگر وجود داشت خطا بده و نتونه اضاف کنه

    @Override
    public void update(UnderService underService) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(underService);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(UnderService underService) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        UnderService deleteUnderService = em.find(UnderService.class, underService.getId());
        em.remove(deleteUnderService);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<UnderService> getAll() {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        List<UnderService> underServiceList = em.createNamedQuery("getAllUnderService").getResultList();
        em.getTransaction().commit();
        em.close();
        return underServiceList;
    }
}
