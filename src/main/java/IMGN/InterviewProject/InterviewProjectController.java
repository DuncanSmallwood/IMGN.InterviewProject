package IMGN.InterviewProject;

import IMGN.InterviewProject.Repositories.Entities.Company;
import IMGN.InterviewProject.Repositories.Entities.Employee;
import IMGN.InterviewProject.Repositories.ICompanyRepository;
import IMGN.InterviewProject.Repositories.IEmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/emloyee")
    Employee newEmployee(@RequestBody Employee newEmployee){
        if (employeeRepository.getById(newEmployee.getId()) != null) {
            employeeRepository.getById(newEmployee.getId());
        }
        return employeeRepository.save(newEmployee);
    }

    //get employee by company
    @GetMapping("employees/{company_id}")
    List<Employee> employeesByCompany(@PathVariable Long companyId){
        List<Employee> allEmployees = employeeRepository.findAll();
        List<Employee> toReturn = new ArrayList<>();
        for (Employee e:
             allEmployees) {
            if(e.getCompanyId().equals(companyId)){
                toReturn.add(e);
            }
        }
        return toReturn;
    }
    //delete one employee

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }
}
