package uz.queue.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.queue.models.Department;
import uz.queue.models.Employee;
import uz.queue.models.OperatorBoard;
import uz.queue.repositories.EmployeeRepository;
import uz.queue.repositories.OperatorBoardRepository;
import uz.queue.services.dao.interfaces.EmployeeDAO;

import java.util.List;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {

    private EmployeeRepository repository;
    private OperatorBoardRepository boardRepository;

    @Autowired
    public EmployeeDAOImpl(EmployeeRepository employeeRepository, OperatorBoardRepository operatorBoardRepository) {
        this.repository = employeeRepository;
        this.boardRepository = operatorBoardRepository;
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
        temp.setBoard(employee.getBoard());

        repository.save(temp);
    }

    @Override
    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }

    @Override
    public OperatorBoard getOperatorBoardForEmployee(Employee employee) {
        return boardRepository.getOperatorBoardByEmployee(employee);
    }
}
