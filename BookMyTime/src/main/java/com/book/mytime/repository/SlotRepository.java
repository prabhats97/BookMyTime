package com.book.mytime.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.book.mytime.domain.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot,String>{

	List<Slot> findAllByAdminEmail(String adminEmail);
	Boolean existsByAdminEmail(String adminEmail);
}
