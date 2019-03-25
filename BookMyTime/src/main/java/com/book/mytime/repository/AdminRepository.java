package com.book.mytime.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.book.mytime.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,String> {
	
	/* Admin addAdmin(Admin admin);
	 List<Admin> getAllAdmin();
	 Admin getAdminById(String adminEmail);
	 Admin updateAdminById(String adminEmail,Admin admin);
	 void deleteAdminById(String admilEmail);
	 Boolean validateAdmin(String adminEmail,String password);*/
	 
}
