package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingsWithDetailsDto;

public interface IJobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	//boolean existsJobTitlesByJobTitle(String jobTitle);
	
	/*@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsWithDetailsDto(j.id, j.jobTitle, j.companyName, j.city, j.publicationDate, j.applicationDeadline, j.availablePosition, j.jobDescription) From JobPosting j")
	List<JobPostingsWithDetailsDto> getJobPostingsWithDetails();*/
	
	
	/*@Query(value = "SELECT new kodlamaio.hrms.entities.dtos.JobPostings(post.companyName, post.jobTitle, post.availablePosition, post.publicationDate, post.applicationDeadline) FROM JobPosting post", nativeQuery = true)
	public List<JobPosting> findJobPosting();*/
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsWithDetailsDto(e.companyName, jt.jobTitleName, ct.cityName, jp.publicationDate, jp.applicationDeadline, jp.availablePosition, jp.jobDescription) "
			+ "From JobPosting jp join JobTitle jt on jp.jobTitle.titleId = jt.titleId "
			+ "join Employer e on jp.employer.employerId = e.employerId join "
			+ "City ct on jp.city.cityId = ct.cityId WHERE jp.isActive = true")
	List<JobPostingsWithDetailsDto> getJobPostingsWithDetails();

	@Query("Select new kodlamaio.hrms.entities.dtos.JobPostingsWithDetailsDto(e.companyName, jt.jobTitleName, ct.cityName, jp.publicationDate, jp.applicationDeadline, jp.availablePosition, jp.jobDescription) "
			+ "From JobPosting jp join JobTitle jt on jp.jobTitle.titleId = jt.titleId "
			+ "join Employer e on jp.employer.employerId = e.employerId join "
			+ "City ct on jp.city.cityId = ct.cityId WHERE jp.isActive = true Order By jp.publicationDate ")
	List<JobPostingsWithDetailsDto> getJobPostingsSortByDate();
	
	@Transactional
    @Modifying
	@Query("UPDATE JobPosting SET isActive=:isActive WHERE jobPostingId=:jobPostingId")
	void updateActivityById(@Param("isActive") boolean activity,@Param("jobPostingId") int jobPostingId); 


}
