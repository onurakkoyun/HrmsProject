package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.IEmployeeCheckService;
import kodlamaio.hrms.dataAccess.abstracts.IEmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class EmployeeCheckManager implements IEmployeeCheckService{
	
	private IEmployeeDao employeeDao;
	

	public EmployeeCheckManager(IEmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}


	@Override
	public boolean isEmployeeEmailVerified(Employee employee) {
		return true;
	}

	@Override
	public boolean isEmployeePasswordMatch(Employee employee) {
		if (employee.getPassword().equals(employee.getRepeatPassword())) {
			return true;
		}
		else {
			return false;
		}
	}


	@Override
	public boolean existsEmployeeByEmail(String email) {
		
		if (this.employeeDao.existsEmployeeByEmail(email)) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean existsEmployeeByIdentityNumber(String identityNumber) {
		if (this.employeeDao.existsEmployeeByIdentityNumber(identityNumber)) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean checkIfRealPerson(Employee employee) {
		
		
		KPSPublicSoapProxy  client = new KPSPublicSoapProxy();
		
		try 
		{
			return client.TCKimlikNoDogrula(Long.parseLong(employee.getIdentityNumber()), employee.getFirstName().toUpperCase(), employee.getLastName().toUpperCase(), employee.getYearOfBirth());
		} 
		catch (Exception e) 
		{
		}
		return false;
	}

	

	

	



}
