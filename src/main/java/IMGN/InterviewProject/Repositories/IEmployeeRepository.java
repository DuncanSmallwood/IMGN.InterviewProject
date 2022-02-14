package IMGN.InterviewProject.Repositories;

import IMGN.InterviewProject.Repositories.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
