package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingsWithDetailsDto;

public interface IEmployeeService {
	
	DataResult<List<Employee>> getAll();
	DataResult<List<JobPosting>> getAllJobPosting();

	DataResult<List<JobPostingsWithDetailsDto>> getJobPostingsWithDetails();
	
	DataResult<List<JobPostingsWithDetailsDto>> getJobPostingsSortByDate();
	
	Result add(Employee employee);
	Result delete(int id);
	
	

}
