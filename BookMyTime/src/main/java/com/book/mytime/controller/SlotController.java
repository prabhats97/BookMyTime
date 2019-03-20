package com.book.mytime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.book.mytime.repository.SlotRepository;

@RestController
public class SlotController {
	
	@Autowired
	SlotRepository slotRepository;

}
