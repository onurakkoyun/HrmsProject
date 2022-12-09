package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;

public interface IEmployerCheckService {
	public boolean isEmployerEmailVerified(Employer employer);
	public boolean isEmployerPasswordMatch(Employer employer);
	public boolean existsEmployerByEmail(String email);
}
