package uz.queue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.queue.models.Service;
import uz.queue.services.dao.interfaces.ServiceDAO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private ServiceDAO dao;

    @Autowired
    public ServiceController(ServiceDAO serviceDAO) {
        this.dao = serviceDAO;
    }

    @GetMapping(value="/get-all")
    public ResponseEntity<List<Service>> getAllServices() {
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @PostMapping(value= "/save")
    public  ResponseEntity<List<Service>> saveService(@Valid @RequestBody Service service){
        dao.saveService(service);
        return new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/get-one/{id}")
    public  ResponseEntity<Service> getOneService(@PathVariable int id){
        return new ResponseEntity<>(dao.getServiceById(id), HttpStatus.OK);
    }

    @PostMapping(value="/update")
    public ResponseEntity<List<Service>> updateService(@Valid @RequestBody Service service){
        dao.editService(service);
        return  new ResponseEntity<>(dao.getAll(), HttpStatus.OK);
    }

    @PostMapping(value="/delete/{id}")
    public ResponseEntity<List<Service>> deleteService(@PathVariable int id){
        dao.deleteService(id);
        return  new ResponseEntity<>(dao.getAll(),HttpStatus.OK);
    }
}
