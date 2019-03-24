package com.book.mytime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.book.mytime.domain.Admin;
import com.book.mytime.service.AdminService;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/* To add a new admin */ 

	@PostMapping(value = "")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin)
	{
		return new ResponseEntity<Admin>(adminService.addAdmin(admin),HttpStatus.CREATED);
	}

	/* To fetch all Admin details */

	@GetMapping(value = "")
	public ResponseEntity<List<Admin>> getAllAdmin()
	{
		return new ResponseEntity<List<Admin>>(adminService.getAllAdmin(),HttpStatus.OK);	
	}

	/* To fetch an Admin details by Id */

	@GetMapping(value = "/{adminEmail}")
	public ResponseEntity<Admin> getAdminById (@PathVariable String adminEmail)
	{
		return new ResponseEntity<Admin>(adminService.getAdminById(adminEmail),HttpStatus.OK);		
	}

	/* To update an Admin details by Id */

	@PutMapping(value = "/{adminEmail}")
	public ResponseEntity<Admin> updateAdminById(@PathVariable String adminEmail,@RequestBody Admin admin)
	{
		return new ResponseEntity<Admin>(adminService.updateAdminById(adminEmail,admin),HttpStatus.OK);
	}


	/* To delete an admin record by Id */

	@DeleteMapping(value = "/{adminEmail}" )
	public ResponseEntity<?> deleteAdminById(@PathVariable String adminEmail)
	{
		adminService.deleteAdminById(adminEmail);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/* To validate an admin for login */
	
	@PostMapping(value = "validateAdmin/{adminEmail}")
	public ResponseEntity<?> validateAdmin(@PathVariable String adminEmail,@RequestParam String password)
	{
		if(adminService.validateAdmin(adminEmail, password))
			return new ResponseEntity<>(HttpStatus.FOUND);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
