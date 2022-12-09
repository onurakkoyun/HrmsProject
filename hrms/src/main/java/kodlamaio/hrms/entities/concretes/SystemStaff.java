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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "system_staffs")
@AllArgsConstructor
@NoArgsConstructor
public class SystemStaff {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "system_staff_id")
	private int systemStaffId;
	
	@NotNull
	@NotBlank
	@Email
	@Column(name = "email")
	private String email;
	
	@NotNull
	@NotBlank
	@Column(name = "password")
	private String password;
	
	@NotNull
	@NotBlank
	private String repeatPassword;

	

}
