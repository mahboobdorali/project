package ir.maktab.repository;

import ir.maktab.madel.entity.Expert;
import ir.maktab.madel.entity.Service;
import ir.maktab.repository.configuration.Config;

import javax.persistence.EntityManager;
import java.util.List;

public class ServiceRepository implements  IRepository<Service>{

    @Override
    public void save(Service service) {
        try {
            EntityManager em = Config.emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(service);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void update(Service service) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(service);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Service service) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        Service deleteService = em.find(Service.class, service.getId());
        em.remove(deleteService);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Service> getAll() {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        List<Service> serviceList = em.createNamedQuery("getAllService").getResultList();
        em.getTransaction().commit();
        em.close();
        return serviceList;
    }
}
