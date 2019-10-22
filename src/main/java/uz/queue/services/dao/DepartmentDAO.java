package uz.queue.services.dao;

import org.springframework.stereotype.Component;
import uz.queue.models.Department;

import java.util.List;

@Component
public interface DepartmentDAO {

    List<Department> getAll();
    Department getById(int id);
    Department getByEmployee(int employee);
    // Department getByServices (int service);
    Department getByName (String name);
    void saveDepartment(Department department);
    void editDepartment(Department department);
    void deleteDepartment(Department department);

}
