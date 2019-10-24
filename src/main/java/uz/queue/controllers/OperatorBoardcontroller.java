package uz.queue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.queue.models.OperatorBoard;
import uz.queue.services.dao.OperatorBoardDAO;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/operatorBoard")
public class OperatorBoardcontroller {
    @Autowired
    OperatorBoardDAO operatorBoardDAO;
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
        return new ResponseEntity<>(operatorBoardDAO.getById(id),HttpStatus.OK);
    }
    @PostMapping(value="/update")
    public ResponseEntity<List<OperatorBoard>> updateBoard(@Valid @RequestBody OperatorBoard operatorBoard){
        operatorBoardDAO.editOperatorBoard(operatorBoard);
        return  new ResponseEntity<>(operatorBoardDAO.getAll(),HttpStatus.OK);
    }
    @PostMapping(value="/delete")
    public ResponseEntity<List<OperatorBoard>> deleteBoard(@Valid @RequestBody OperatorBoard operatorBoard){
        operatorBoardDAO.deleteOperatorBoard(operatorBoard);
        return  new ResponseEntity<>(operatorBoardDAO.getAll(),HttpStatus.OK);
    }
}
