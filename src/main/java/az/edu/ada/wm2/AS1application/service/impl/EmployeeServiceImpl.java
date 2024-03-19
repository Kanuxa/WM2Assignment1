package az.edu.ada.wm2.AS1application.service.impl;

import az.edu.ada.wm2.AS1application.model.Employee;
import az.edu.ada.wm2.AS1application.repository.EmployeeRepository;
import az.edu.ada.wm2.AS1application.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository categoryRepo;

    public EmployeeServiceImpl (EmployeeRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Employee> list() {
        return (List<Employee>) categoryRepo.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return categoryRepo.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }
}
