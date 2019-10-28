package uz.queue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.queue.models.Department;
import uz.queue.services.dao.interfaces.DepartmentDAO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentDAO dao;

    @Autowired
    public DepartmentController(DepartmentDAO departmentDAO) {
        this.dao = departmentDAO;
    }

    @GetMapping(value = "get-all")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<List<Department>> saveDepartment(@Valid @RequestBody Department department) {
        dao.saveDepartment(department);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<List<Department>> updateDepartment(@Valid @RequestBody Department department) {
        dao.editDepartment(department);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable int id) {
        dao.deleteDepartment(id);
        return new ResponseEntity<>(dao.getById(id), HttpStatus.OK);
    }
}
