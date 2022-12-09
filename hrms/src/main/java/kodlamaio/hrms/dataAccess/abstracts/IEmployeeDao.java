package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employee;

public interface IEmployeeDao extends JpaRepository<Employee, Integer>{

	boolean existsEmployeeByEmail(String email);
	boolean existsEmployeeByIdentityNumber(String identityNumber);

}
