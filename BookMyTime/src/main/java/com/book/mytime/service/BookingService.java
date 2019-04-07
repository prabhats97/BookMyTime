package com.book.mytime.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mytime.domain.Admin;
import com.book.mytime.domain.Booking;
import com.book.mytime.domain.Slot;
import com.book.mytime.exception.RecordNotFoundException;
import com.book.mytime.repository.BookingRepository;

@Service
@Transactional
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public Booking addBooking(Booking booking){
		return bookingRepository.save(booking);
	}

	public List<Booking> getAllBooking() {
		List<Booking> bookingList = bookingRepository.findAll();
		if(bookingList.isEmpty())
			throw new RecordNotFoundException("No Admin Records Found");
		return bookingList;
	}


	public Booking getBookingById(String bookingId) {
		if(!bookingRepository.existsById(bookingId))
			throw new RecordNotFoundException("Booking Id: "+ bookingId + " doesn't exist");
		return bookingRepository.findById(bookingId).get();
	}


	public Booking getBookingBySlotId(String slotId) {
		if(!bookingRepository.existsBySlotId(slotId))
			throw new RecordNotFoundException("Slot Id: "+ slotId + " doesn't exist");
		return bookingRepository.findBySlotId(slotId);
	}

	public List<Booking> getAllBookingByUserId(String userEmail) {
		if(!bookingRepository.existsByUserEmail(userEmail))
			throw new RecordNotFoundException("Bookings: "+ userEmail + " doesn't exist");
		return bookingRepository.findAllByUserEmail(userEmail);
	}

	public Booking cancelBooking(String bookingId, Booking booking) {
		if(!bookingRepository.existsById(bookingId))
			throw new RecordNotFoundException("Booking Id: "+ bookingId + " doesn't exist");
		return bookingRepository.save(booking);
	}

	public void deleteBookingById(String bookingId) {
		if(!bookingRepository.existsById(bookingId))
			throw new RecordNotFoundException("Booking Id: "+ bookingId + " doesn't exist");
		bookingRepository.deleteById(bookingId);

	}
}
