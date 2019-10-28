package uz.queue.services.dao.interfaces;

import uz.queue.models.Department;

import java.util.List;

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
