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

import com.book.mytime.domain.Refund;
import com.book.mytime.service.RefundService;

@RestController
@RequestMapping("/refund")
public class RefundController {

	@Autowired
	private RefundService refundService;
	
	/* To add a new refund */ 

	@PostMapping(value = "")
	public ResponseEntity<Refund> addRefund(@RequestBody Refund refund)
	{
		return new ResponseEntity<Refund>(refundService.addRefund(refund),HttpStatus.CREATED);
	}

	/* To fetch all refund details */

	@GetMapping(value = "")
	public ResponseEntity<List<Refund>> getAllRefund()
	{
		return new ResponseEntity<List<Refund>>(refundService.getAllRefund(),HttpStatus.OK);	
	}

	/* To fetch refund details by Refund Id */

	@GetMapping(value = "/{refundId}")
	public ResponseEntity<Refund> getRefundById (@PathVariable String refundId)
	{
		return new ResponseEntity<Refund>(refundService.getRefundById(refundId),HttpStatus.OK);		
	}
	
	/* To fetch refund details by Booking Id */

	@GetMapping(value = "booking/{bookingId}")
	public ResponseEntity<List<Refund>> getRefundByBookingId (@PathVariable String bookingId)
	{
		return new ResponseEntity<List<Refund>>(refundService.getAllRefundByBookingId(bookingId),HttpStatus.OK);		
	}

	/* To update refund details by Booking Id */

	@PutMapping(value = "/{refundId}")
	public ResponseEntity<Refund> updateRefundById(@PathVariable String refundId,@RequestBody Refund refund)
	{
		return new ResponseEntity<Refund>(refundService.updateRefundById(refundId,refund),HttpStatus.OK);
	}


	/* To delete refund record by Id */

	@DeleteMapping(value = "/{refundId}" )
	public ResponseEntity<?> deleteRefundById(@PathVariable String refundId)
	{
		refundService.deleteRefundById(refundId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
