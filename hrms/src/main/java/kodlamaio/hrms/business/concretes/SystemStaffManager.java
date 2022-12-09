package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ISystemStaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ISystemStaffDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.SystemStaff;

@Service
public class SystemStaffManager implements ISystemStaffService{
	
	private ISystemStaffDao systemStaffDao;

	@Autowired
	public SystemStaffManager(ISystemStaffDao systemStuffDao) {
		super();
		this.systemStaffDao = systemStuffDao;
	}

	@Override
	public DataResult<List<SystemStaff>> getAll() {
		return new SuccessDataResult<List<SystemStaff>>
		(this.systemStaffDao.findAll(), "Sistem çalışanları listelendi");
	}

	@Override
	public Result add(SystemStaff systemStuff) {
		if (systemStuff.getPassword().equals(systemStuff.getRepeatPassword())) {

			this.systemStaffDao.save(systemStuff);
			return new SuccessResult("Sistem çalışanı eklendi");
			
		}
		else {
			return new ErrorResult("Şifreler eşleşmiyor");
		}
	}

	@Override
	public Result delete(int id) {
		this.systemStaffDao.deleteById(id);
		return new SuccessResult("Sistem çalışanı silindi");
	}

	@Override
	public boolean isStaffVerifiedEmployerEmail(Employer employer) {
		return true;
	}

}
