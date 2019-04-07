package com.book.mytime.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.mytime.domain.Refund;

public interface RefundRepository extends JpaRepository<Refund,String>{

	boolean existsByBookingId(String bookingId);

	List<Refund> findAllByBookingId(String bookingId);

}
