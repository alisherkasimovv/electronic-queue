package uz.queue.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.queue.models.Department;
import uz.queue.repositories.DepartmentRepository;
import uz.queue.services.dao.DepartmentDAO;

import java.util.List;
@Service
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(int id) {
        return departmentRepository.findById(id);
    }

    @Override
    public Department getByEmployee(int employee) {
        return departmentRepository.findByEmployee(employee);
    }

    @Override
    public Department getByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void editDepartment(Department department) {

        Department temp= departmentRepository.findById(department.getId());
        temp.setName(department.getName());
        temp.setDescription(department.getDescription());
        temp.setService(department.getService());
        temp.setEmployee(department.getEmployee());

        departmentRepository.save(temp);
    }

    @Override
    public void deleteDepartment(Department department) {
departmentRepository.delete(department);
    }
}
