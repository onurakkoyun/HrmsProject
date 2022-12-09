package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface IJobPostingService {

	DataResult<List<JobPosting>> getAll();
	Result delete(int id);
	
	//public boolean existsJobTitlesByJobTitle(String jobTitle);
	
	
	
}
