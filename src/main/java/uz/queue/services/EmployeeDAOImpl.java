package uz.queue.services;

import org.springframework.beans.factory.annotation.Autowired;
import uz.queue.models.Employee;
import uz.queue.repositories.EmployeeRepository;
import uz.queue.services.dao.EmployeeDAO;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
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
        temp.setPortrait(employee.getPortrait());

        repository.save(temp);
    }

    @Override
    public void deleteEmplyee(Employee employee) {
        repository.delete(employee);
    }
}
