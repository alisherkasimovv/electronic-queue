package uz.queue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.queue.models.Department;
import uz.queue.models.Employee;
import uz.queue.models.OperatorBoard;
import uz.queue.models.Service;
import uz.queue.services.dao.interfaces.DepartmentDAO;
import uz.queue.services.dao.interfaces.EmployeeDAO;
import uz.queue.services.dao.interfaces.OperatorBoardDAO;
import uz.queue.services.dao.interfaces.ServiceDAO;
import uz.queue.wrappers.EmployeeWrapper;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeDAO dao;

    private DepartmentDAO departmentDAO;
    private OperatorBoardDAO boardDAO;
    private ServiceDAO serviceDAO;
    private EmployeeWrapper wrapper = new EmployeeWrapper();

    @Autowired
    public EmployeeController(
            EmployeeDAO employeeDAO,
            DepartmentDAO departmentDAO,
            OperatorBoardDAO operatorBoardDAO,
            ServiceDAO serviceDAO) {
        this.dao = employeeDAO;
        this.boardDAO = operatorBoardDAO;
        this.departmentDAO = departmentDAO;
        this.serviceDAO = serviceDAO;
    }

    @GetMapping(value = "/get-all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        return new ResponseEntity<>(dao.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Employee>> saveEmployee(@Valid @RequestBody Employee employee) {
        dao.saveEmployee(employee);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<List<Employee>> updateEmployee(@Valid @RequestBody Employee employee) {
        dao.editEmployee(employee);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        dao.deleteEmployee(id);
        return new ResponseEntity<>(dao.getById(id), HttpStatus.OK);
    }

    private EmployeeWrapper collectWrapper() {
        List<Department> departments = departmentDAO.getAll();
        List<Service> services = serviceDAO.getAll();
        List<OperatorBoard> boards = boardDAO.getAll();

        wrapper.setEmployees(dao.getAll());
        wrapper.setBoards(boards);
        wrapper.setDepartments(departments);
        wrapper.setServices(services);

        return wrapper;
    }
}
