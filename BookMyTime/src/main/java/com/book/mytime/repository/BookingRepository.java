package com.book.mytime.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.book.mytime.domain.Booking;

public interface BookingRepository extends JpaRepository<Booking,String>{

	/*
	List<Booking> findAllByAdminEmail(String adminEmail);
	Boolean existsByAdminEmail(String adminEmail);
	*/

	List<Booking> findAllByUserEmail(String userEmail);
	Boolean existsByUserEmail(String userEmail);
	boolean existsBySlotId(String slotId);
	Booking findBySlotId(String slotId);
}
