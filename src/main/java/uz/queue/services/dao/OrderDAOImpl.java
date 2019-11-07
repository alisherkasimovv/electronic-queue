package uz.queue.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.queue.models.Employee;
import uz.queue.models.Order;
import uz.queue.repositories.OrderRepository;
import uz.queue.services.dao.interfaces.OrderDAO;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class OrderDAOImpl implements OrderDAO {

    private OrderRepository repository;

    @Autowired
    public OrderDAOImpl(OrderRepository orderRepository) {
        this.repository = orderRepository;
    }


    @Override
    public List<Order> getAllForToday() {
        return repository.findAll();
    }

    @Override
    public List<Order> getAllPending() {
        return repository.findAllByOrderPerformedIsFalse();
    }

    @Override
    public Order findById(int id) {
        return repository.findById(id);
    }

    /**
     * Creates new order in DB with given index number and service
     * Alongside sets timestamp for registration.
     * @param orderIndex Current queue index
     * @param service Chosen service by Customer
     * @return Saved new order instance
     */
    @Override
    public Order createOrder(int orderIndex, uz.queue.models.Service service) {
        Order order = new Order();

        order.setService(service);
        order.setIndexNumber(orderIndex);
        order.setRegisteredDate(LocalDateTime.now());

        return repository.save(order);
    }

    /**
     * Set Order status as accepted by Employee
     * @param orderIndex Current queue index
     * @param employee Employee who accepted this Order
     * @return Updated order instance
     */
    @Override
    public Order setOrderAsAccepted(int orderIndex, Employee employee) {
        Order order = repository.findByIndexNumber(orderIndex);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime registered = order.getRegisteredDate();

        order.setOrderExecutor(employee.getFirstName() + " " + employee.getLastName());
        order.setAcceptedDate(now);
        order.setTimeSpentWaitingInQueue(ChronoUnit.MINUTES.between(now, registered));
        return order;
    }

    /**
     * Sets Order status as performed
     * @param orderIndex Current queue index
     * @return Updated order instance
     */
    @Override
    public Order setOrderAsPerformed(int orderIndex) {
        Order order = repository.findByIndexNumber(orderIndex);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime accepted = order.getAcceptedDate();

        order.setPerformedDate(now);
        order.setOrderPerformed(true);
        order.setOrderPassed(false);
        order.setPassedDate(null);
        order.setTimeTakenToComplete(ChronoUnit.MINUTES.between(now, accepted));

        return order;
    }

    /**
     * Sets Order status as passed. This action could be done only if
     * @param orderIndex Current queue index
     * @return Updated order instance
     */
    @Override
    public Order setOrderAsPassed(int orderIndex) {
        Order order = repository.findByIndexNumber(orderIndex);

        if (order.getOrderExecutor() != null) {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime accepted = order.getAcceptedDate();

            order.setOrderPassed(true);
            order.setOrderPerformed(false);
            order.setPassedDate(now);
            order.setVisitorWaitingTime(ChronoUnit.MINUTES.between(now, accepted));
            order.setPerformedDate(null);
        }


        return order;
    }
}
