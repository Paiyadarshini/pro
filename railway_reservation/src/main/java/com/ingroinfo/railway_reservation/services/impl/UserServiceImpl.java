package com.ingroinfo.railway_reservation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingroinfo.railway_reservation.entity.AddingTrains;
import com.ingroinfo.railway_reservation.entity.BookingTicket;
import com.ingroinfo.railway_reservation.entity.TrainMaster;
import com.ingroinfo.railway_reservation.entity.User;
import com.ingroinfo.railway_reservation.repository.AddingTrainsRepository;
import com.ingroinfo.railway_reservation.repository.BookingTicketRepository;
import com.ingroinfo.railway_reservation.repository.UserRepository;
import com.ingroinfo.railway_reservation.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private AddingTrainsRepository addingTrainsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private BookingTicketRepository bookingTicketRepository;
	
	@Override
	public User saveUsers(User user) {
		User savedUser = this.userRepository.save(user);
		return savedUser;
	}

	@Override
	public boolean checkEmail(String emailId) {
		return this.userRepository.existsByEmailId(emailId);
	}

	@Override
	public BookingTicket saveBookingTicket(BookingTicket bookingTicket) {
	BookingTicket	savedBookingTicket= this.bookingTicketRepository.save(bookingTicket);
		return savedBookingTicket;
	}

	@Override
	public List<BookingTicket> findAllBookingTicket() {
		
		return this.bookingTicketRepository.findAll();
	}

	
	

}
