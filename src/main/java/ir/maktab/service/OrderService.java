package ir.maktab.service;

import ir.maktab.madel.entity.OrdersCustomer;

import java.util.List;

public interface OrderService {
    void saveOrder(OrdersCustomer ordersCustomer);

    void updateOrder(OrdersCustomer ordersCustomer);

    void deleteOrder(OrdersCustomer ordersCustomer);

    List<OrdersCustomer> getAllOrders();
}
