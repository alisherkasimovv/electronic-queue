package uz.queue.services.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.queue.models.Department;
import uz.queue.repositories.DepartmentRepository;
import uz.queue.services.dao.interfaces.DepartmentDAO;

import java.util.List;

@Service
public class DepartmentDAOImpl implements DepartmentDAO {

    private DepartmentRepository repository;

    @Autowired
    public DepartmentDAOImpl(DepartmentRepository departmentRepository) {
        this.repository = departmentRepository;
    }

    @Override
    public List<Department> getAll() {
        return repository.findAll();
    }

    @Override
    public Department getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Department getByEmployee(int employee) {
        return repository.findByEmployees(employee);
    }

    @Override
    public Department getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void saveDepartment(Department department) {
        repository.save(department);
    }

    @Override
    public void editDepartment(Department department) {

        Department temp= repository.findById(department.getId());
        temp.setName(department.getName());
        temp.setDescription(department.getDescription());

        repository.save(temp);
    }

    @Override
    public void deleteDepartment(int id) {
repository.deleteById(id);
    }
}
