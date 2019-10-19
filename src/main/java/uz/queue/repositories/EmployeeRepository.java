package uz.queue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.queue.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUsername(String username);
    Employee findById(int id);

}
