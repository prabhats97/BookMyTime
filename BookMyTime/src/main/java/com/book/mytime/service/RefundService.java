package com.book.mytime.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.mytime.domain.Refund;
import com.book.mytime.exception.IdAlreadyExists;
import com.book.mytime.exception.RecordNotFoundException;
import com.book.mytime.repository.RefundRepository;

@Service
@Transactional
public class RefundService {

	@Autowired
	private RefundRepository refundRepository;

	public Refund addRefund(Refund refund){
		if(refundRepository.existsById(refund.getBookingId()))
			throw new IdAlreadyExists("Booking Id: " + refund.getBookingId() + " already exists");
		return refundRepository.save(refund);
	}

	public List<Refund> getAllRefund() {
		List<Refund> refundList = refundRepository.findAll();
		if(refundList.isEmpty())
			throw new RecordNotFoundException("No Refund Records Found");
		return refundList;
	}


	public Refund getRefundById(String bookingId) {
		if(!refundRepository.existsById(bookingId))
			throw new RecordNotFoundException("Booking Id: "+ bookingId + " doesn't exist");
		return refundRepository.findById(bookingId).get();
	}


	public Refund updateRefundById(String bookingId, Refund refund) {
		if(!refundRepository.existsById(bookingId))
			throw new RecordNotFoundException("Booking Id: "+ bookingId + " doesn't exist");
		return refundRepository.save(refund);
	}


	public void deleteRefundById(String bookingId) {
		if(!refundRepository.existsById(bookingId))
			throw new RecordNotFoundException("Booking Id: "+ bookingId + " doesn't exist");
		refundRepository.deleteById(bookingId);
	}
}
