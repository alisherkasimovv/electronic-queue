package uz.queue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.queue.models.Order;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Override
    List<Order> findAll();
    List<Order> findAllByServedIsFalseAndCreateDateTimeBetween(LocalDateTime start, LocalDateTime end);
    Order findById(int id);
}
