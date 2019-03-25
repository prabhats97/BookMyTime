package com.book.mytime.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.mytime.domain.Slot;
import com.book.mytime.exception.IdAlreadyExists;
import com.book.mytime.exception.RecordNotFoundException;
import com.book.mytime.repository.SlotRepository;

@Service
@Transactional
public class SlotService {

	@Autowired
	private SlotRepository slotRepository;

	public Slot addSlot(Slot slot){
		if(slotRepository.existsById(slot.getSlotId()))
			throw new IdAlreadyExists("slot Id: " + slot.getSlotId() + " already exists");
		return slotRepository.save(slot);
	}

	public List<Slot> getAllSlot() {
		List<Slot> slotList = slotRepository.findAll();
		if(slotList.isEmpty())
			throw new RecordNotFoundException("No Slot Records Found");
		return slotList;
	}

	public Slot getSlotById(String slotId) {
		if(!slotRepository.existsById(slotId))
			throw new RecordNotFoundException("Slot Id: "+ slotId + " doesn't exist");
		return slotRepository.findById(slotId).get();
	}

	public List<Slot> getAllSlotByAdminId(String adminEmail) {
		if(!slotRepository.existsByAdminEmail(adminEmail))
			throw new RecordNotFoundException("Slots with "+ adminEmail + " doesn't exist");
		return slotRepository.findAllByAdminEmail(adminEmail);
	}

	public Slot updateSlotById(String slotId,Slot slot) {
		if(!slotRepository.existsById(slotId))
			throw new RecordNotFoundException("Slot Id: "+ slotId + " doesn't exist");
		return slotRepository.save(slot);
	}

	public void deleteSlotById(String slotId) {
		if(!slotRepository.existsById(slotId))
			throw new RecordNotFoundException("Slot Id: "+ slotId + " doesn't exist");
		slotRepository.deleteById(slotId);
	}	
	
}
