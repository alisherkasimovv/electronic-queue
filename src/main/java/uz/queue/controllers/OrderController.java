package uz.queue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.queue.models.Employee;
import uz.queue.models.Order;
import uz.queue.models.Service;
import uz.queue.services.dao.interfaces.EmployeeDAO;
import uz.queue.services.dao.interfaces.OrderDAO;
import uz.queue.services.dao.interfaces.ServiceDAO;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/orders")
public class OrderController {

    private OrderDAO dao;
    private ServiceDAO serviceDAO;
    private EmployeeDAO employeeDAO;

    private int orderIndex = 1;

    @Autowired
    public OrderController(OrderDAO dao, ServiceDAO serviceDAO, EmployeeDAO employeeDAO) {
        this.dao = dao;
        this.serviceDAO = serviceDAO;
        this.employeeDAO = employeeDAO;
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Order>> getAllRegistered() {
        return new ResponseEntity<>(dao.getAllPending(), HttpStatus.OK);
    }

    @GetMapping(value = "/register/{serviceId}")
    public void registerNewOrder(@PathVariable int serviceId) {
        Service service = serviceDAO.getServiceById(serviceId);

        dao.createOrder(incrementIndex(), service);
    }

    @GetMapping(value = "/accept/{order}/{employee}")
    public void acceptOrder(@PathVariable("order") int order, @PathVariable("employee") int employee) {
        Employee employee1 = employeeDAO.getById(employee);

        dao.setOrderAsAccepted(order, employee1);
    }

    @GetMapping(value = "/reject/{id}")
    public void rejectOrder(@PathVariable int id) {

        dao.setOrderAsPassed(id);

    }

    private int incrementIndex() {
        return orderIndex++;
    }
}
