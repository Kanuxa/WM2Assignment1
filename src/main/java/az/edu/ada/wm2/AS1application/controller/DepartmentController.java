package az.edu.ada.wm2.AS1application.controller;

import az.edu.ada.wm2.AS1application.model.Department;
import az.edu.ada.wm2.AS1application.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping({"", "/", "/list"})
    public String getDepartments(Model model) {
        List<Department> departments = departmentService.list();
        model.addAttribute("departments", departmentService.list());
        LOGGER.info(departments.toString());

        return "departments/index";
    }

    @GetMapping("/new")
    public String createNewdepartment(Model model) {
        model.addAttribute("department", new Department());
        return "departments/new";
    }

    @PostMapping("/")
    public String save(@ModelAttribute("department") Department department) {
        departmentService.save(department);
        return "redirect:/department/";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id) {
        model.addAttribute("department", departmentService.getById(id));
        return "departments/info";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        departmentService.deleteById(id);
        return "redirect:/department/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateDepartment(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("departments/update");

        mv.addObject("department", departmentService.getById(id));
        return mv;
    }

}
