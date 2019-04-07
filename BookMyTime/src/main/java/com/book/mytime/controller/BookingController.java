package com.book.mytime.controller;

import java.util.ArrayList;
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

import com.book.mytime.domain.Booking;
import com.book.mytime.domain.Slot;
import com.book.mytime.service.BookingService;
import com.book.mytime.service.SlotService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private SlotService slotService;

	/* To add a new booking */ 

	@PostMapping(value = "")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking)
	{
		return new ResponseEntity<Booking>(bookingService.addBooking(booking),HttpStatus.CREATED);
	}

	/* To get the list of all bookings */

	@GetMapping(value = "")
	public ResponseEntity<List<Booking>> getAllBooking()
	{
		return new ResponseEntity<List<Booking>>(bookingService.getAllBooking(),HttpStatus.OK);	
	}

	/* To fetch booking details by Booking Id */

	@GetMapping(value = "/{bookingId}")
	public ResponseEntity<Booking> getBookingById (@PathVariable String bookingId)
	{
		return new ResponseEntity<Booking>(bookingService.getBookingById(bookingId),HttpStatus.OK);		
	}
	
	/* To fetch booking details by Slot Id */

	@GetMapping(value = "/slot/{slotId}")
	public ResponseEntity<Booking> getBookingBySlotId (@PathVariable String slotId)
	{
		return new ResponseEntity<Booking>(bookingService.getBookingBySlotId(slotId),HttpStatus.OK);		
	}

	/* To fetch booking details by User Email */

	@GetMapping(value = "/user/{userEmail}")
	public ResponseEntity<List<Booking>> getAllBookingByUserId (@PathVariable String userEmail)
	{
		return new ResponseEntity<List<Booking>>(bookingService.getAllBookingByUserId(userEmail),HttpStatus.OK);		
	}
	
	/* To fetch booking details by Admin Email */

	@GetMapping(value = "/admin/{adminEmail}")
	public ResponseEntity<List<Booking>> getAllBookingByAdminId (@PathVariable String adminEmail)
	{
		List<Slot> slotList = slotService.getAllSlotByAdminId(adminEmail);
		List<Booking> bookingList = new ArrayList<Booking>();
		for(Slot slot : slotList)
		{
			bookingList.add(bookingService.getBookingBySlotId(slot.getSlotId()));
		}
		return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.OK);		
	}

	/* To cancel booking */

	@PutMapping(value = "/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable String bookingId,@RequestBody Booking booking)
	{
		return new ResponseEntity<Booking>(bookingService.cancelBooking(bookingId,booking),HttpStatus.OK);
	}

	/* To delete Booking by Id */

	@DeleteMapping(value = "/{bookingId}" )
	public ResponseEntity<?> deleteBookingById(@PathVariable String bookingId)
	{
		bookingService.deleteBookingById(bookingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
