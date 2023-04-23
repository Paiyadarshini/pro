package com.ingroinfo.railway_reservation.services;

import java.util.List;

import com.ingroinfo.railway_reservation.entity.AddingTrains;
import com.ingroinfo.railway_reservation.entity.BookingTicket;
import com.ingroinfo.railway_reservation.entity.User;

public interface UserService {

	
	User saveUsers(User user);

	boolean checkEmail(String emailId);

	BookingTicket saveBookingTicket(BookingTicket bookingTicket);

	List<BookingTicket> findAllBookingTicket();
 
	
		
		

	
	
}
