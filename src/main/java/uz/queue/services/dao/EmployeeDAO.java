package uz.queue.services.dao;

import uz.queue.models.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAll();
    Employee getById(int id);
    Employee getByUsername(String username);
    void saveEmployee(Employee employee);
    void editEmployee(Employee employee);
    void deleteEmplyee(Employee employee);

}
