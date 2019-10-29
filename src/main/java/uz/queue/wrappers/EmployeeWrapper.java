package uz.queue.wrappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uz.queue.models.Department;
import uz.queue.models.Employee;
import uz.queue.models.OperatorBoard;
import uz.queue.models.Service;
import uz.queue.services.dao.interfaces.EmployeeDAO;
import uz.queue.services.dao.interfaces.OperatorBoardDAO;

import java.util.List;

/**
 * Employee wrapper class is used to collect information from multiple tables on database
 * and sent using ResponseEntity.
 */
@Component
public class EmployeeWrapper {

    private List<OperatorBoard> boards;
    private List<Department> departments;
    private List<Employee> employees;
    private List<Service> services;

    public List<OperatorBoard> getBoards() {
        return boards;
    }

    public void setBoards(List<OperatorBoard> boards) {
        this.boards = boards;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
