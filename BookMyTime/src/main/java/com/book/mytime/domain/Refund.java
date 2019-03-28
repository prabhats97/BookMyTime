package com.book.mytime.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "refund_info")
public class Refund {

	@Id
	@Column(name = "booking_id")
	private String bookingId;
	
	@Column(name = "refund_amount")
	private long refundAmount;
	
	@Column(name = "refund_status")
	private String refundStatus;
	
	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public long getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(long refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

}
