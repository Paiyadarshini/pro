package com.ingroinfo.railway_reservation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ingroinfo.railway_reservation.entity.User;
import com.ingroinfo.railway_reservation.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		User user = userRepository.findByEmailId(emailId);
		if (user !=null) {
			return new CustomUserDetails(user);
		}
		throw new  UsernameNotFoundException("User Not Avalable !!");
	}

}

