package iuh.fit.se.controllers;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public ModelAndView getList(ModelAndView mav) {
        List<Employee> employees = employeeService.findAll();
        mav.addObject("employees", employees);
        mav.setViewName("list");
        return mav;
    }

    @GetMapping("/show-form")
    public ModelAndView showForm(ModelAndView modelAndView) {
        Employee employee = new Employee();
        modelAndView.addObject("employee", employee);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        employeeService.save(employee);
        return "redirect:/";   // quay về trang danh sách
    }


    @GetMapping("/update")
    public ModelAndView showFormUpdate(@RequestParam("employeeId") int id, ModelAndView modelAndView) {
        Employee employee = employeeService.findById(id);

        if(employee == null) {
            modelAndView.setViewName("error");
            modelAndView.addObject("errorMessage", "Employee - not found");
        }
        else {

            modelAndView.addObject("employee", employee);
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }
}
