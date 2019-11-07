package uz.queue.services.dao.interfaces;

import uz.queue.models.Employee;
import uz.queue.models.Order;
import uz.queue.models.Service;

import java.util.List;

public interface OrderDAO {

    List<Order> getAllForToday();
    List<Order> getAllPending();
    Order findById(int id);

    Order createOrder(int orderIndex, Service service);
    // TODO From OrderController Employee should send his credentials

    Order setOrderAsAccepted(int orderIndex, Employee employee);
    Order setOrderAsPerformed(int orderIndex);
    Order setOrderAsPassed(int orderIndex);

}
