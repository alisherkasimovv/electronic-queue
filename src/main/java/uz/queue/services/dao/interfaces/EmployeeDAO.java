package uz.queue.services.dao.interfaces;

import uz.queue.models.Department;
import uz.queue.models.Employee;
import uz.queue.models.OperatorBoard;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAll();
    List<Employee> getAllInDepartment(Department department);
    Employee getById(int id);
    Employee getByUsername(String username);
    void saveEmployee(Employee employee);
    void editEmployee(Employee employee);
    void deleteEmployee(int id);

    OperatorBoard getOperatorBoardForEmployee(Employee employee);
}
