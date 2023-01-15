package ir.maktab.repository;

import ir.maktab.madel.entity.Customer;
import ir.maktab.repository.configuration.Config;

import javax.persistence.EntityManager;
import java.util.List;

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
        Customer deleteCustomer= em.find(Customer.class, customer.getId());
        em.remove(deleteCustomer);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Customer> getAll() {

        EntityManager em =Config.emf.createEntityManager();
        em.getTransaction().begin();
        List<Customer> customerList = em.createNamedQuery("getAllCustomer").getResultList();
        em.getTransaction().commit();
        em.close();
        return customerList;
    }

//    public Optional<Student> getByUserNameAndPassword(String username, String password) {
//        Student person;
//        try {
//            EntityManager em = EntityManagerFactoryProducer.emf.createEntityManager();
//            em.getTransaction().begin();
//            Query query = em.createQuery("from Student s where s.accountInfo.username =:username and s.accountInfo.password =:password");
//            query.setParameter("username", username);
//            query.setParameter("password", password);
//            person = (Student) query.getSingleResult();
//            em.getTransaction().commit();
//            em.close();
//        } catch (NoResultException e) {
//            person = null;
//        }
//        return Optional.ofNullable(person);
//    }
//    }
}
