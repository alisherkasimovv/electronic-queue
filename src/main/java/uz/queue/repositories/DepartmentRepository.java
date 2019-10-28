package uz.queue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.queue.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByName(String name);
    Department findById (int Id);
    Department findByEmployees(int employee);

}
