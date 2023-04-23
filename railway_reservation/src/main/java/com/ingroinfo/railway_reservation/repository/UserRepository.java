package com.ingroinfo.railway_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ingroinfo.railway_reservation.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	boolean existsByEmailId(String emailId);

	User findByEmailId(String emailId);

	
	
}
