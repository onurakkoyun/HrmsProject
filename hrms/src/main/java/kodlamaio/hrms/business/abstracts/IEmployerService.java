package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface IEmployerService {

	DataResult<List<Employer>> getAll();
	
	Result updateActivityById(@Param("isActive") boolean activity,@Param("jobPostingId") int jobPostingId);
	Result add(Employer employer);
	Result addJobPosting(JobPosting jobPosting);
	Result delete(int id);
	
	
}
