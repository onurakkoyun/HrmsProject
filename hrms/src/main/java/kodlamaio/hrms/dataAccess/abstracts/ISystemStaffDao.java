package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SystemStaff;

public interface ISystemStaffDao extends JpaRepository<SystemStaff, Integer>{

}
