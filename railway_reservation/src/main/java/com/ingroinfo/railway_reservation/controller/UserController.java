package com.ingroinfo.railway_reservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ingroinfo.railway_reservation.entity.AddingTrains;
import com.ingroinfo.railway_reservation.entity.BookingTicket;
import com.ingroinfo.railway_reservation.entity.TrainMaster;
import com.ingroinfo.railway_reservation.repository.AddingTrainsRepository;
import com.ingroinfo.railway_reservation.services.AdminService;
import com.ingroinfo.railway_reservation.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;	
	@Autowired
	private AdminService adminService;
	@Autowired
	private AddingTrainsRepository addingTrainsRepository;
	
	@GetMapping("/index")
   public String  index(Model model) {
		List<AddingTrains> showAddingTrain = adminService.findAllAddingTrains();
		model.addAttribute("showAddingTrain", showAddingTrain);
	   return "/user/user_index";
   }
	
	@GetMapping(path="/booktrain/{trainId}")
	  public String showBookingTrain(@PathVariable("trainId")long trainId,Model model) {
		  Optional<AddingTrains> temp = addingTrainsRepository.findById(trainId);
		  AddingTrains addingTrains =temp.get();
		  model.addAttribute("addingTrains", addingTrains);
		return "/user/booking_ticket";
   
}

	
	@PostMapping("/bookingticket")
	public String submitBookingTicket(@ModelAttribute("BookingTicket") BookingTicket bookingTicket) {
		this.userService.saveBookingTicket(bookingTicket);

		return "redirect:/user/showbookingticket";
}
	@GetMapping("/showbookingticket")
	public String showTrainDetails(Model model) {
		List<BookingTicket> showBookingTicket = userService.findAllBookingTicket();
		model.addAttribute("showBookingTicket", showBookingTicket);
		return "user/show_bookingticket";
	
}
	@GetMapping("/userprofile")
	public String displayUserProfilePage(Model model) {
		
		return "user/profile";

}
}
