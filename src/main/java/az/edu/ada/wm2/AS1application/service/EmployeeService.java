package az.edu.ada.wm2.AS1application.service;


import az.edu.ada.wm2.AS1application.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> list();

    Employee save(Employee employee);

    Employee getById(Long id);

    void deleteById(Long id);

}