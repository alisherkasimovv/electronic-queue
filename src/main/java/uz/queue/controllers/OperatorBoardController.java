package uz.queue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.queue.models.OperatorBoard;
import uz.queue.services.dao.interfaces.OperatorBoardDAO;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/boards")
public class OperatorBoardController {

    private OperatorBoardDAO operatorBoardDAO;

    @Autowired
    public OperatorBoardController(OperatorBoardDAO operatorBoardDAO) {
        this.operatorBoardDAO = operatorBoardDAO;
    }

    @GetMapping(value="/get-all")
    public ResponseEntity<List<OperatorBoard>> getAllBoards() {
        return new ResponseEntity<>(operatorBoardDAO.getAll(), HttpStatus.OK);
    }

    @PostMapping(value= "/save")
    public  ResponseEntity<List<OperatorBoard>> saveBoard(@Valid @RequestBody OperatorBoard operatorBoard){
        operatorBoardDAO.saveOperatorBoard(operatorBoard);
        return new ResponseEntity<>(operatorBoardDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public  ResponseEntity<OperatorBoard> getOneOperator(@PathVariable int id){
        return new ResponseEntity<>(operatorBoardDAO.getById(id), HttpStatus.OK);
    }

    @PostMapping(value="/update")
    public ResponseEntity<List<OperatorBoard>> updateBoard(@Valid @RequestBody OperatorBoard operatorBoard){
        operatorBoardDAO.editOperatorBoard(operatorBoard);
        return  new ResponseEntity<>(operatorBoardDAO.getAll(), HttpStatus.OK);
    }

    @GetMapping(value="/delete/{id}")
    public ResponseEntity<List<OperatorBoard>> deleteBoard(@PathVariable int id){
        operatorBoardDAO.deleteOperatorBoard(id);
        return  new ResponseEntity<>(operatorBoardDAO.getAll(),HttpStatus.OK);
    }
}
