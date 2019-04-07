package com.book.mytime.domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slot_info")
public class Slot {
	
	@Id
	@Column(name = "slot_id")
	private String slotId;
	
	@Column(name = "slot_name")
	private String slotName;
	
	@Column(name = "admin_email")
	private String adminEmail;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "time")
	private Time time;
	
	@Column(name = "slot_available")
	private Boolean slotAvailable;
	
	@Column(name = "serviceCharge")
	private double serviceCharge;
	
	@Column(name = "location")
	private String location;

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Boolean getSlotAvailable() {
		return slotAvailable;
	}

	public void setSlotAvailable(Boolean slotAvailable) {
		this.slotAvailable = slotAvailable;
	}

	public double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
