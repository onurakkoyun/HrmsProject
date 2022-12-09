package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Employee;

public interface IEmployeeCheckService {
	
	public boolean existsEmployeeByEmail(String email);
	
	public boolean existsEmployeeByIdentityNumber(String identityNumber);
	
	public boolean isEmployeeEmailVerified(Employee employee);
	public boolean isEmployeePasswordMatch(Employee employee);
	
	public boolean checkIfRealPerson(Employee employee);
	


}
