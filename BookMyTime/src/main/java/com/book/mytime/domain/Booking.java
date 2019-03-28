package com.book.mytime.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_info")
public class Booking {

	@Id
	@Column(name = "booking_id")
	private String bookingId;

	@Column(name = "slot_id")
	private String slotId;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "paid_amount", columnDefinition="Decimal(10,2) default '0.00'")
	private long paidAmount;

	@Column(name = "balance_amount", columnDefinition="Decimal(10,2) default '0.00'")
	private long balanceAmount;

	@Column(name = "booking_status")
	private String bookingStatus;

	@Column(name = "transaction_id")
	private String transactionId;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public long getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(long paidAmount) {
		this.paidAmount = paidAmount;
	}

	public long getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
