package uz.queue.services.dao.interfaces;

import uz.queue.models.Employee;
import uz.queue.models.Order;

import java.util.List;

public interface OrderDAO {

    List<Order> getAllForToday();
    Order findById(int id);
    Order setOrderServed();
    Order setServantEmployee(Employee employee);

}
