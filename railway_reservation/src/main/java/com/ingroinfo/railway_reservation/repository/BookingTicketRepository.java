package com.ingroinfo.railway_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingroinfo.railway_reservation.entity.BookingTicket;
@Repository
public interface BookingTicketRepository extends JpaRepository<BookingTicket, Long> {

	
}
