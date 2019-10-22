package uz.queue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.queue.models.Department;

@Component
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByName(String name);
    Department findById (int Id);
    Department findByEmployee(int employee);

}
