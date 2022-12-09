package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employees"})
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	
	@NotNull
	@NotBlank(message = "Ad boş olamaz")
	@Size(min = 2, message = "Ad en az 2 haneli olmalıdır")
	@Column(name = "firstname")
	private String firstName;
	
	@NotNull
	@NotBlank(message = "Soyad boş olamaz")
	@Size(min = 2, message = "Soyad en az 2 haneli olmalıdır")
	@Column(name = "lastname")
	private String lastName;
	
	@NotNull
	@NotBlank(message = "Kimlik numarası boş olamaz")
	@Column(name = "identity_number",  unique = true)
	@Size(min = 11, max = 11, message = "Kimlik numarası 11 haneli olmalıdır")
	private String identityNumber;
	
	@Column(name = "year_of_birth")
	private int yearOfBirth;
	
	@NotNull
	@NotBlank
	@Email
	@Column(name = "email", length = 30, nullable = false, unique = true)
	private String email;
	
	@NotNull
	@NotBlank(message = "Şifre boş olamaz")
	@Column(name = "password")
	private String password;
	
	@NotNull
	@NotBlank(message = "Şifre tekrarı boş olamaz")
	private String repeatPassword;
	

}
