package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobPosting"}) 
public class Employer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employer_id")
	private int employerId;
	
	@NotNull
	@NotBlank
	@Size(min = 2)
	@Column(name = "company_name")
	private String companyName;
	
	@NotNull
	@NotBlank
	@Column(name = "website")
	private String website;
	
	@NotNull
	@NotBlank
	@Email
	@Column(name = "email")
	private String email;
	
	@NotNull
	@NotBlank
	@Pattern(regexp ="[0-9\\s]{12}")
	@Column(name = "phone")
	private String phoneNumber;
	
	@NotNull
	@NotBlank
	@Column(name = "password")
	private String password;
	
	private String repeatPassword;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	List<JobPosting> jobPostings;
	

}
