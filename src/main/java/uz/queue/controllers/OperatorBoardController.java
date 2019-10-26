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

@Controller
@RequestMapping("/operator-board")
public class OperatorBoardController {

    private OperatorBoardDAO operatorBoardDAO;

    @Autowired
    public OperatorBoardController(OperatorBoardDAO operatorBoardDAO) {
        this.operatorBoardDAO = operatorBoardDAO;
    }

    @GetMapping(value="/get-all")
    public ResponseEntity<List<OperatorBoard>> getAllBoards() {
        return new ResponseEntity<>(operatorBoardDAO.getAll(),HttpStatus.OK);
    }

    @PostMapping(value= "/save")
    public  ResponseEntity<List<OperatorBoard>> saveBoard(@Valid @RequestBody OperatorBoard operatorBoard){
        operatorBoardDAO.saveOperatorBoard(operatorBoard);
        return new ResponseEntity<>(operatorBoardDAO.getAll(),HttpStatus.OK);
    }

    @PostMapping(value = "/get-one/{id}")
    public  ResponseEntity<OperatorBoard> getOneOperator(@PathVariable int id){
        return new ResponseEntity<>(operatorBoardDAO.getById(id), HttpStatus.OK);
    }

    @PostMapping(value="/update")
    public ResponseEntity<List<OperatorBoard>> updateBoard(@Valid @RequestBody OperatorBoard operatorBoard){
        operatorBoardDAO.editOperatorBoard(operatorBoard);
        return  new ResponseEntity<>(operatorBoardDAO.getAll(), HttpStatus.OK);
    }

    @PostMapping(value="/delete")
    public ResponseEntity<List<OperatorBoard>> deleteBoard(@Valid @RequestBody OperatorBoard operatorBoard){
        operatorBoardDAO.deleteOperatorBoard(operatorBoard);
        return  new ResponseEntity<>(operatorBoardDAO.getAll(),HttpStatus.OK);
    }
}
