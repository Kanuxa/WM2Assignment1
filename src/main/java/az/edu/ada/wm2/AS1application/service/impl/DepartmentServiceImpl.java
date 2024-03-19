package az.edu.ada.wm2.AS1application.service.impl;

import az.edu.ada.wm2.AS1application.model.Department;
import az.edu.ada.wm2.AS1application.repository.DepartmentRepository;
import az.edu.ada.wm2.AS1application.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository categoryRepo;

    public DepartmentServiceImpl (DepartmentRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Department> list() {
        return (List<Department>) categoryRepo.findAll();
    }

    @Override
    public Department save(Department department) {
        return categoryRepo.save(department);
    }

    @Override
    public Department getById(Long id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id);
    }
}
