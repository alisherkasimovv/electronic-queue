package uz.queue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.queue.models.Department;
import uz.queue.models.Service;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

    Service findById(int id);
    List<Service> findServicesByDepartment(Department department);
    Service deleteById(int id);

}
