package az.edu.ada.wm2.AS1application.repository;

import az.edu.ada.wm2.AS1application.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
