package uz.queue.services.dao;

import org.springframework.stereotype.Service;
import uz.queue.models.Department;
import uz.queue.models.Employee;
import uz.queue.repositories.EmployeeRepository;
import uz.queue.services.dao.interfaces.EmployeeDAO;

import java.util.List;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {

    private EmployeeRepository repository;

    public EmployeeDAOImpl(EmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Employee> getAllInDepartment(Department department) {
        return repository.findByDepartment(department);
    }

    @Override
    public Employee getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Employee getByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void editEmployee(Employee employee) {
        Employee temp = repository.findById(employee.getId());
        temp.setUsername(employee.getUsername());
        temp.setFirstName(employee.getFirstName());
        temp.setLastName(employee.getLastName());

        repository.save(temp);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        repository.delete(employee);
    }
}
