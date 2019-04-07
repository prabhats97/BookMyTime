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
		if(refundRepository.existsById(refund.getRefundId()))
			throw new IdAlreadyExists("Refund Id: " + refund.getRefundId() + " already exists");
		return refundRepository.save(refund);
	}

	public List<Refund> getAllRefund() {
		List<Refund> refundList = refundRepository.findAll();
		if(refundList.isEmpty())
			throw new RecordNotFoundException("No Refund Records Found");
		return refundList;
	}


	public Refund getRefundById(String refundId) {
		if(!refundRepository.existsById(refundId))
			throw new RecordNotFoundException("Refund Id: "+ refundId + " doesn't exist");
		return refundRepository.findById(refundId).get();
	}
	

	public List<Refund> getAllRefundByBookingId(String bookingId) {
		if(!refundRepository.existsByBookingId(bookingId))
			throw new RecordNotFoundException("Refunds with: "+ bookingId + " doesn't exist");
		return refundRepository.findAllByBookingId(bookingId);
	}

	public Refund updateRefundById(String refundId, Refund refund) {
		if(!refundRepository.existsById(refundId))
			throw new RecordNotFoundException("Refund Id: "+ refundId + " doesn't exist");
		return refundRepository.save(refund);
	}


	public void deleteRefundById(String refundId) {
		if(!refundRepository.existsById(refundId))
			throw new RecordNotFoundException("Booking Id: "+ refundId + " doesn't exist");
		refundRepository.deleteById(refundId);
	}

}
