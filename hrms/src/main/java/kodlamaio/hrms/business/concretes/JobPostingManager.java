package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.IJobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.IJobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements IJobPostingService{
	
	private IJobPostingDao jobPostingDao;

	public JobPostingManager(IJobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>
		(this.jobPostingDao.findAll(), "İş pozisyonları listelendi");
	}


	@Override
	public Result delete(int id) {
		this.jobPostingDao.deleteById(id);
		return new SuccessResult("İş pozisyonu silindi");
	}

	


	/*@Override
	public boolean existsJobTitlesByJobTitle(String jobTitle) {
		if (this.jobPostingDao.existsJobTitlesByJobTitle(jobTitle)) {
			return false;
		}
		else {
			return true;
		}
	}*/

	
	
	

}
