package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.SystemStaff;

public interface ISystemStaffService {

	DataResult<List<SystemStaff>> getAll();
	Result add(SystemStaff systemStuff);
	Result delete(int id);
	
	public boolean isStaffVerifiedEmployerEmail(Employer employer);
}
