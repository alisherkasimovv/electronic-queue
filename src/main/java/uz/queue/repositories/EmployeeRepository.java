package uz.queue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.queue.models.Department;
import uz.queue.models.Employee;

import java.util.List;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUsername(String username);
    Employee findById(int id);
    List<Employee> findByDepartment(Department department);

}
