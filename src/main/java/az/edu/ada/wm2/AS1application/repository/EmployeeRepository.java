package az.edu.ada.wm2.AS1application.repository;

import az.edu.ada.wm2.AS1application.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}