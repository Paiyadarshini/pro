package com.ingroinfo.railway_reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ingroinfo.railway_reservation.entity.User;
import com.ingroinfo.railway_reservation.services.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/dashboard")
	public String showHome(Model model) {
		return "home";
	}

	@GetMapping("/about")
	public String showAbout() {
		return "aboutUs";
	}

	@GetMapping("/contact")
	public String showcontact() {
		return "contactUs";
	}

	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}

	@GetMapping("/signin")
	public String showlogin() {
		return "login";
	}

	// Register User
	@PostMapping("/doRegister")
	public String submitUserResgistration(@ModelAttribute("User") User user) {
		boolean f = this.userService.checkEmail(user.getEmailId());
		if (f) {
			System.out.println("Email Already Present !!");
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRole("ROLE_USER");
			this.userService.saveUsers(user);
		}
		  return "redirect:/home/register";
	}

}

