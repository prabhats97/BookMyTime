package com.book.mytime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.book.mytime.domain.Admin;
import com.book.mytime.repository.AdminRepository;

@RestController
public class AdminController {

		@Autowired
		AdminRepository adminRepository;
		
		@RequestMapping("/getHello")
		
		public String getHello()
		{
			return "hello";
		}
		
		@PostMapping("/addAdmin")
		public String addAdmin(@RequestBody Admin admin)
			{
			adminRepository.save(admin);
		        return "Saved Successfully";

			}
}
