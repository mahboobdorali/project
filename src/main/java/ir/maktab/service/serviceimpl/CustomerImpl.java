package ir.maktab.service.serviceimpl;

import ir.maktab.madel.entity.Customer;
import ir.maktab.madel.entity.OrdersCustomer;
import ir.maktab.madel.entity.UnderService;
import ir.maktab.repository.CustomerRepository;
import ir.maktab.service.CustomerService;
import ir.maktab.util.DateUtil;
import ir.maktab.validation.Validate;

import javax.persistence.NoResultException;

import java.util.*;

public class CustomerImpl implements CustomerService {
    private static OrderImpl orderImpl = new OrderImpl();
    private static CustomerRepository customerRepository = new CustomerRepository();
    private static UnderServiceImpl underServiceImpl = new UnderServiceImpl();
    private static DutyJobTaskImpl dutyJobTask = new DutyJobTaskImpl();
    private static UnderService underService = new UnderService();

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public List<Customer> showAllCustomers() {
        return customerRepository.getAll();
    }

    @Override
    public Customer logInCustomer(String emailAddress, String password) {
        Customer customer = customerRepository.getByEmail(emailAddress).orElseThrow(() -> new NoResultException(" there is'nt any customer with this emailAddress!!"));
        if (customer.getPassword().equals(password))
            return customer;
        throw new NoResultException("is not exist password");
    }

    @Override
    public void updatePasswordByEmailAddress(String password, String emailAddress) {
        customerRepository.updatePasswordByEmailAddress(password, emailAddress);
    }

    public static void showAllUnderService() {
        underServiceImpl.showAllUnderService();
    }

    public static void showAllService() {
        dutyJobTask.showAllMainService();
    }

    public void Order(OrdersCustomer ordersCustomer) {
        showAllService();
        showAllUnderService();

    if (ordersCustomer.getProposedPrice() >= underService.getBasePrice()) {
            DateUtil.isDateValid(ordersCustomer.getDateAndTimeOfWork());
            orderImpl.saveOrder(ordersCustomer);
        } else throw new NoResultException("invalid inputs!!!");
    }
}

