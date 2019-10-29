package uz.queue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.queue.models.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Override
    List<Department> findAll();

    Department findByName(String name);
    Department findById (int Id);
    Department findByEmployees(int employee);

}
