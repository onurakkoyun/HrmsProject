package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.IEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.IEmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.IJobPostingDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class EmployerManager implements IEmployerService{

	private IEmployerDao employerDao;
	private IJobPostingDao jobPostingDao;
	private SystemStaffManager systemStaffManager;
	private EmployerCheckManager employerCheckManager;
	@Autowired
	public EmployerManager(IEmployerDao employerDao,EmployerCheckManager employerCheckManager, SystemStaffManager systemStaffManager, IJobPostingDao jobPostingDao) {
		super();
		this.employerDao = employerDao;
		this.employerCheckManager = employerCheckManager;
		this.systemStaffManager = systemStaffManager;
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(), "İş verenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		
			if (employerCheckManager.isEmployerPasswordMatch(employer)) {
					if (systemStaffManager.isStaffVerifiedEmployerEmail(employer)) {
						
						if (employerCheckManager.existsEmployerByEmail(employer.getEmail())) {
							
							this.employerDao.save(employer);
							return new SuccessResult("İş veren eklendi");
							
						}
						else {
							return new ErrorResult("Bu email sistemde kayıtlı!");
						}
						
						
						
					}
					else {
						return new ErrorResult("Personel emailinizi henüz doğrulamadı!");
					}
					
				
			}
			else {
				return new ErrorResult("Şifreler eşleşmiyor!");
			}
		
		
	}

	@Override
	public Result delete(int id) {
		this.employerDao.deleteById(id);
		return new SuccessResult("İşçi silindi");
	}

	// Employer service kısmında iş ekleme tanımlamadığımız için override ile çağırmadık.
	public Result addJobPosting(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public Result updateActivityById(boolean activity, int jobPostingId) {
		this.jobPostingDao.updateActivityById(activity, jobPostingId);
		return new SuccessResult("İş durumu güncellendi");
	}




	
	
}
