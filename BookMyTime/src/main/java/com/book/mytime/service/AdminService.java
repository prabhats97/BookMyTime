package com.book.mytime.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.mytime.domain.Admin;
import com.book.mytime.exception.IdAlreadyExists;
import com.book.mytime.exception.RecordNotFoundException;
import com.book.mytime.repository.AdminRepository;


@Service
@Transactional
public class AdminService  {

	@Autowired
	private AdminRepository adminRepository;

	public Admin addAdmin(Admin admin){
		if(adminRepository.existsById(admin.getAdminEmail()))
			throw new IdAlreadyExists("Email Id: " + admin.getAdminEmail() + " already exists");
		return adminRepository.save(admin);
	}

	public List<Admin> getAllAdmin() {
		List<Admin> adminList = adminRepository.findAll();
		if(adminList.isEmpty())
			throw new RecordNotFoundException("No Admin Records Found");
		return adminList;
	}


	public Admin getAdminById(String adminEmail) {
		if(!adminRepository.existsById(adminEmail))
			throw new RecordNotFoundException("Email Id: "+ adminEmail + " doesn't exist");
		return adminRepository.findById(adminEmail).get();
	}


	public Admin updateAdminById(String adminEmail, Admin admin) {
		if(!adminRepository.existsById(adminEmail))
			throw new RecordNotFoundException("Email Id: "+ adminEmail + " doesn't exist");
		return adminRepository.save(admin);
	}


	public void deleteAdminById(String adminEmail) {
		if(!adminRepository.existsById(adminEmail))
			throw new RecordNotFoundException("Email Id: "+ adminEmail + " doesn't exist");
		adminRepository.deleteById(adminEmail);
	}	

	public Boolean validateAdmin(String adminEmail,String password)
	{
		if(!adminRepository.existsById(adminEmail))
			throw new RecordNotFoundException("Email Id: "+ adminEmail + " doesn't exist");
		Admin admin = adminRepository.findById(adminEmail).get();
		if(admin.getPassword() == password)
			return true; 
		return false;
	}

}
