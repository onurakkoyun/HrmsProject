package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.IEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.IEmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.IJobPostingDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingsWithDetailsDto;

@Service
public class EmployeeManager implements IEmployeeService{
	
	private IEmployeeDao employeeDao;
	private EmployeeCheckManager employeeCheckManager;
	private IJobPostingDao jobPostingDao;
	
	@Autowired
	public EmployeeManager(IEmployeeDao employeeDao, EmployeeCheckManager employeeCheckManager, IJobPostingDao jobPostingDao) {
		super();
		this.employeeDao = employeeDao;
		this.employeeCheckManager = employeeCheckManager;
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>
		(this.employeeDao.findAll(), "İş arayanlar listelendi");
	}
	
	@Override
	public DataResult<List<JobPosting>> getAllJobPosting() {
		return new SuccessDataResult<List<JobPosting>>
		(this.jobPostingDao.findAll(), "İş ilanları listelendi");
	}


	@Override
	public Result add(Employee employee) {		
			if (employeeCheckManager.isEmployeePasswordMatch(employee)) {
				
				if (employeeCheckManager.existsEmployeeByEmail(employee.getEmail())) {
					
					if (employeeCheckManager.existsEmployeeByIdentityNumber(employee.getIdentityNumber())) {
						
						if (employeeCheckManager.isEmployeeEmailVerified(employee)) {
						
								this.employeeDao.save(employee);
								return new SuccessResult("İş arayan eklendi");
							
						}
						else {
							return new ErrorResult("Email doğrulanmadı!");
						}
						
					}
					else {
						return new ErrorResult("Bu kimlik numarası sistemde kayıtlı!");
					}
					
				}
				else {
					return new ErrorResult("Bu email sistemde kayıtlı!");
				}
			}
			else {
				return new ErrorResult("Şifreler eşleşmiyor!");
			}
		
		
	}

	@Override
	public Result delete(int id) {
		this.employeeDao.deleteById(id);
		return new SuccessResult("İşçi silindi");
	}

	@Override
	public DataResult<List<JobPostingsWithDetailsDto>> getJobPostingsWithDetails() {
		return new SuccessDataResult<List<JobPostingsWithDetailsDto>>
		(this.jobPostingDao.getJobPostingsWithDetails(), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostingsWithDetailsDto>> getJobPostingsSortByDate() {
		return new SuccessDataResult<List<JobPostingsWithDetailsDto>>
		(this.jobPostingDao.getJobPostingsSortByDate(), "Data Listelendi");
	}




	
}
