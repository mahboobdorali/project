package ir.maktab.repository;

import ir.maktab.madel.entity.OrdersCustomer;
import ir.maktab.repository.configuration.Config;

import javax.persistence.EntityManager;
import java.util.List;

public class OrderRepository implements IRepository<OrdersCustomer> {

    @Override
    public void save(OrdersCustomer ordersCustomer) {
        try {
            EntityManager em = Config.emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(ordersCustomer);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void update(OrdersCustomer ordersCustomer) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(ordersCustomer);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(OrdersCustomer ordersCustomer) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        OrdersCustomer deleteOrdersCustomer = em.find(OrdersCustomer.class, ordersCustomer.getId());
        em.remove(deleteOrdersCustomer);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<OrdersCustomer> getAll() {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        List<OrdersCustomer> ordersCustomerList = em.createNamedQuery("getAllOrder").getResultList();
        em.getTransaction().commit();
        em.close();
        return ordersCustomerList;
    }
}
