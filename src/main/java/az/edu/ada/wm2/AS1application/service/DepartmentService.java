package az.edu.ada.wm2.AS1application.service;


import az.edu.ada.wm2.AS1application.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> list();

    Department save(Department department);

    Department getById(Long id);

    void deleteById(Long id);

}