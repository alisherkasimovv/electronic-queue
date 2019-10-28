package uz.queue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.queue.models.Employee;
import uz.queue.models.OperatorBoard;
import uz.queue.services.dao.interfaces.EmployeeDAO;
import uz.queue.services.dao.interfaces.OperatorBoardDAO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeDAO dao;
    private OperatorBoardDAO boardDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO, OperatorBoardDAO operatorBoardDAO) {
        this.dao = employeeDAO;
        this.boardDAO = operatorBoardDAO;
    }

    @GetMapping(value = "get-all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<OperatorBoard> boards = boardDAO.getAll();
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
}
