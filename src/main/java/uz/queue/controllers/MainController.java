package uz.queue.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    private ModelAndView obj = new ModelAndView();

    @GetMapping(value = "/")
    public ModelAndView home() {
        obj.setViewName("dashboard");
        return obj;
    }

    @RequestMapping(value = "/employees")
    public ModelAndView actionEmployees() {
        obj.setViewName("pages/employees");
        return obj;
    }

    @RequestMapping(value = "/boards")
    public ModelAndView actionBoards() {
        obj.setViewName("pages/boards");
        return obj;
    }

    @RequestMapping(value = "/services")
    public ModelAndView actionServices() {
        obj.setViewName("pages/services");
        return obj;
    }

    @RequestMapping(value = "/departments")
    public ModelAndView actionDepartments() {
        obj.setViewName("pages/departments");
        return obj;
    }

}
