package uz.queue.wrappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.queue.models.Employee;
import uz.queue.models.OperatorBoard;
import uz.queue.services.dao.interfaces.EmployeeDAO;
import uz.queue.services.dao.interfaces.OperatorBoardDAO;

import java.util.List;

public class EmployeeWrapper {

    private List<Employee> employees;
    private List<OperatorBoard> boards;

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<OperatorBoard> getBoards() {
        return boards;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setBoards(List<OperatorBoard> boards) {
        this.boards = boards;
    }
}
