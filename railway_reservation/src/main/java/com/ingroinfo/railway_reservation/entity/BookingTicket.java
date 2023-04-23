package com.ingroinfo.railway_reservation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class BookingTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainId;
	private String trainName;
	private String trainFrom;
	private String trainTo;
	private String trainFromTiming;
	private String trainToTime;
	private String ticketPrice;
	private String schedule;
	private String noOfStop;
	private String name;
	private String address;
	private String phoneNumber;
	private String aadharNumber;
	private String age;
	private String gender;
}
