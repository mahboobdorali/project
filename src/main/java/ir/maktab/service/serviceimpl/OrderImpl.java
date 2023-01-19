package ir.maktab.service.serviceimpl;

import ir.maktab.madel.entity.OrdersCustomer;
import ir.maktab.repository.OrderRepository;
import ir.maktab.service.OrderService;

import java.util.List;

public class OrderImpl implements OrderService {
    private static final OrderRepository orderRepository = new OrderRepository();

    @Override
    public void saveOrder(OrdersCustomer ordersCustomer) {
        orderRepository.save(ordersCustomer);
    }

    @Override
    public void updateOrder(OrdersCustomer ordersCustomer) {
        orderRepository.update(ordersCustomer);
    }

    @Override
    public void deleteOrder(OrdersCustomer ordersCustomer) {
        orderRepository.delete(ordersCustomer);
    }

    @Override
    public List<OrdersCustomer> getAllOrders() {
        return orderRepository.getAll();
    }
}
