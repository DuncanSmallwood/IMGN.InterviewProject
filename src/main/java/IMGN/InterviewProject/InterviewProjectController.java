package IMGN.InterviewProject;

import IMGN.InterviewProject.Repositories.Entities.Company;
import IMGN.InterviewProject.Repositories.Entities.Employee;
import IMGN.InterviewProject.Repositories.ICompanyRepository;
import IMGN.InterviewProject.Repositories.IEmployeeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterviewProjectController {
    private final ICompanyRepository companyRepository;
    private final IEmployeeRepository employeeRepository;

    InterviewProjectController(ICompanyRepository cRepo, IEmployeeRepository eRepo){
        companyRepository = cRepo;
        employeeRepository = eRepo;
    }

    //put/create company/employee
    @PostMapping("/company")
    Company newCompany(@RequestBody Company newCompany){
        if (companyRepository.getById(newCompany.getId()) != null){
            return companyRepository.getById(newCompany.getId());
        }
        return companyRepository.save(newCompany);
    }
    //get employee by company
    //delete one employee
}
