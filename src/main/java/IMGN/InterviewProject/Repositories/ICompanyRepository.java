package IMGN.InterviewProject.Repositories;

import IMGN.InterviewProject.Repositories.Entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Long> {
}
