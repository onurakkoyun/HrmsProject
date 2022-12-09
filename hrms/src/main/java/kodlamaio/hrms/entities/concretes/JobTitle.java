package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "job_titles")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobPosting"}) 
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "title_id")
	private int titleId;
	
	@NotNull
	@NotBlank
	@Column(name = "job_title")
	private String jobTitleName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobTitle")
	List<JobPosting> jobPostings;

	@Override
	public String toString() {
		return "JobTitle [titleId=" + titleId + ", jobTitleName=" + jobTitleName + ", jobPostings=" + jobPostings + "]";
	}

}
