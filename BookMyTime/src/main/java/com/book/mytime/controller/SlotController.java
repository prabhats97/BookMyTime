package com.book.mytime.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import com.book.mytime.domain.Slot;
import com.book.mytime.service.SlotService;

@RestController
@RequestMapping("/slot")
public class SlotController {

	@Autowired
	SlotService slotService;

	/* To add a new slot */ 

	@PostMapping(value = "")
	public ResponseEntity<Slot> addSlot(@RequestBody Slot slot)
	{
		return new ResponseEntity<Slot>(slotService.addSlot(slot),HttpStatus.CREATED);
	}

	/* To fetch all Slot details */

	@GetMapping(value = "")
	public ResponseEntity<List<Slot>> getAllAdmin()
	{
		return new ResponseEntity<List<Slot>>(slotService.getAllSlot(),HttpStatus.OK);	
	}

	/* To fetch Slot detail by Id */

	@GetMapping(value = "/{slotId}")
	public ResponseEntity<Slot> getAdminById (@PathVariable String slotId)
	{
		return new ResponseEntity<Slot>(slotService.getSlotById(slotId),HttpStatus.OK);		
	}

	/* To fetch all Slots of an Admin */

	@GetMapping(value = "/admin/{adminEmail}")
	public ResponseEntity<List<Slot>> getAllSlotByAdminId (@PathVariable String adminEmail)
	{
		return new ResponseEntity<List<Slot>>(slotService.getAllSlotByAdminId(adminEmail),HttpStatus.OK);		
	}

	/* To update Slot detail by Id */

	@PutMapping(value = "/{slotId}")
	public ResponseEntity<Slot> updateAdminById(@PathVariable String slotId,@RequestBody Slot slot)
	{
		return new ResponseEntity<Slot>(slotService.updateSlotById(slotId,slot),HttpStatus.OK);
	}


	/* To delete Slot by Id */

	@DeleteMapping(value = "/{slotId}" )
	public ResponseEntity<?> deleteAdminById(@PathVariable String slotId)
	{
		slotService.deleteSlotById(slotId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
