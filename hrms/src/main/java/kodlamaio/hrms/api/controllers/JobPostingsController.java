package kodlamaio.hrms.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.IJobPostingService;
import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/jobPostings")
public class JobPostingsController {
	
	private IJobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(IJobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService;
	}
	
	@DeleteMapping("/{id}")
	 public Result deleteById(@PathVariable("id") int id) {
	    return this.jobPostingService.delete(id);
	 }
	
	

}
