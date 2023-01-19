package ir.maktab.service;

import ir.maktab.madel.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    List<Customer> showAllCustomers();

    Customer logInCustomer(String emailAddress,String password);

    void updatePasswordByEmailAddress(String password, String emailAddress);
}
