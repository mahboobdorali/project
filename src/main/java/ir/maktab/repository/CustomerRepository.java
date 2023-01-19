package ir.maktab.repository;

import ir.maktab.madel.entity.Customer;
import ir.maktab.madel.entity.Expert;
import ir.maktab.repository.configuration.Config;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements IRepository<Customer> {
    @Override
    public void save(Customer customer) {
        try {
            EntityManager em = Config.emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void update(Customer customer) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Customer customer) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        Customer deleteCustomer = em.find(Customer.class, customer.getId());
        em.remove(deleteCustomer);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Customer> getAll() {

        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        List<Customer> customerList = em.createNamedQuery("getAllCustomer").getResultList();
        em.getTransaction().commit();
        em.close();
        return customerList;
    }

    public Optional<Customer> getByEmail(String emailAddress) {
        Customer customer;
        try {
            EntityManager em = Config.emf.createEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("from Customer c where c.emailAddress =:emailAddress");
            query.setParameter("emailAddress", emailAddress);
            customer = (Customer) query.getSingleResult();
            em.getTransaction().commit();
            em.close();
        } catch (NoResultException e) {
            customer = null;
        }
        return Optional.ofNullable(customer);
    }


    public void updatePasswordByEmailAddress(String password, String emailAddress) {
        EntityManager em = Config.emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("update Customer e set e.password =:password" +
                " where e.emailAddress =:emailAddress");
        query.setParameter("password", password);
        query.setParameter("emailAddress", emailAddress);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
