package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.IEmployerCheckService;
import kodlamaio.hrms.dataAccess.abstracts.IEmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements IEmployerCheckService{
	
	private IEmployerDao employerDao;
	
	

	public EmployerCheckManager(IEmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	

	@Override
	public boolean isEmployerEmailVerified(Employer employer) {
		return true;
	}

	@Override
	public boolean isEmployerPasswordMatch(Employer employer) {
		if (employer.getPassword().equals(employer.getRepeatPassword())) {
			return true;
		}
		else {
			return false;
		}
	}


	@Override
	public boolean existsEmployerByEmail(String email) {
		if (this.employerDao.existsEmployerByEmail(email)) {
			return false;
		}
		else {
			return true;
		}
	}

}
