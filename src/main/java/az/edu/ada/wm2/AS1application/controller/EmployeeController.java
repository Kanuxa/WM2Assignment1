package az.edu.ada.wm2.AS1application.controller;

import az.edu.ada.wm2.AS1application.model.Employee;
import az.edu.ada.wm2.AS1application.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"", "/", "/list"})
    public String getEmployees(Model model) {
        List<Employee> employees = employeeService.list();
        model.addAttribute("employees", employeeService.list());
        LOGGER.info(employees.toString());

        return "employees/index";
    }

    @GetMapping("/new")
    public String createNewEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("employee", employeeService.getById(id));
        return "employees/info";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/employee/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateemployee(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employees/update");

        mv.addObject("employee", employeeService.getById(id));
        return mv;
    }

}
