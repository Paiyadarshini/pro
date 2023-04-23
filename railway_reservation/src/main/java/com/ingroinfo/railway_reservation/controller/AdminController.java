package com.ingroinfo.railway_reservation.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ingroinfo.railway_reservation.entity.AddingTrains;
import com.ingroinfo.railway_reservation.entity.Message;
import com.ingroinfo.railway_reservation.entity.NoOfStops;
import com.ingroinfo.railway_reservation.entity.TrainMaster;
import com.ingroinfo.railway_reservation.repository.AddingTrainsRepository;
import com.ingroinfo.railway_reservation.repository.NoOfStopsRepository;
import com.ingroinfo.railway_reservation.repository.TrainMasterRepository;
import com.ingroinfo.railway_reservation.services.AdminService;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private static final Long Long = null;
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AddingTrainsRepository addingTrainsRepository;
	
	@Autowired
      private TrainMasterRepository trainMasterRepository;
	@Autowired
	private NoOfStopsRepository noOfStopsRepository;
	
	// Handler for Display Admin Dashboard
	@GetMapping("/home")
	public String displayAdminHomePage(Model model) {
		return "admin/home";
	}

	// Display TrainMaster Page
	@GetMapping("/trainmaster")
	public String trainMaster(Model model) {
		return "admin/trainmaster";
	}

	@GetMapping("/noofstop")
	public String shownoOfStop() {
		return "admin/noofstop";
	}

	// Submit Train Master Data

	@PostMapping("/submit/trainMaster")
	public String submitTrainMaster(@ModelAttribute("TrainMaster") TrainMaster trainMaster) {
		this.adminService.saveTrainMaster(trainMaster);

		trainMaster.setNoOfStop(trainMaster.getNoOfStop());
		return "redirect:/admin/trainmaster";
	}

	// Display All Train Data

	@GetMapping("/showtrain")
	public String showingTrain(Model model) {
		List<TrainMaster> showTrainDetails = adminService.findAllTrainMaster();
		model.addAttribute("showTrainDetail", showTrainDetails);
		return "admin/showtrain";
	}

	// Submit Train Master Data

	@GetMapping("/addtrain")
	public String submitAddTrain(Model model) {
		List<TrainMaster> listOfTrainMasters = this.adminService.findAllTrainMaster();
		model.addAttribute("listOfTrainMaster", listOfTrainMasters);
		model.addAttribute("listOfNoOfStop", adminService.findAllNoOfStops());
		model.addAttribute("trainmaster", new TrainMaster());
		return "admin/add_train";
		
		}
	
	// save adding train data
	@PostMapping("/addingtrains")
	public String submitAddingTrains(@ModelAttribute("AddingTrains") AddingTrains addingTrains) {
		this.adminService.saveAddTrain(addingTrains);

		return "redirect:/admin/addtrain";
	}

	// get Master Train By Train Id
	@GetMapping("/trainMaster/details/{trainId}")
	public String getTrainMasterdataByTrainMasterId(@PathVariable Long trainId, Model model) {
		TrainMaster trainMaster = this.adminService.getTrainMasterDetailsByTrainId(trainId);
		model.addAttribute("trainmaster", trainMaster);
//		List<TrainMaster> listOfTrainMasters = this.adminService.findAllTrainMaster();
//		model.addAttribute("listOfTrainMaster", listOfTrainMasters);
		model.addAttribute("listOfNoOfStop", adminService.findAllNoOfStops());
		return "admin/add_train";
	}

	// submit no of stops
	@PostMapping("/submit/noOfStop")
	public String submitNoOfStops(@ModelAttribute("NoOfStops") NoOfStops noOfStops, HttpSession session) {
		this.adminService.saveNoOfStops(noOfStops);
		session.setAttribute("message", new Message("Data Submitted Successfully !! ", "success"));
		return "redirect:/admin/noofstop";
	}

	// Display train master in view page
	@GetMapping("/viewtrainmaster")
	public String showTrainMaster(Model model) {
		List<TrainMaster> viewMasters = adminService.findAllTrainMaster();
		model.addAttribute("viewMasters", viewMasters);
		return "admin/viewtrainmaster";
	}

	// display no of stop in view page
	@GetMapping("/viewnoofstop")
	public String showNoOfStop(Model model) {
		List<NoOfStops> viewNoOfStops = adminService.findAllNoOfStops();
		model.addAttribute("listOfNoOfStops", viewNoOfStops);
		return "admin/view_noofStops";
 	}

	// display adding train in show train page
	@GetMapping("/showaddingtrains")
	public String showTrainDetails(Model model) {
		List<AddingTrains> showAddingTrain = adminService.findAllAddingTrains();
		model.addAttribute("showAddingTrain", showAddingTrain);
		return "admin/showtrain";
	}

	// delete train master
	@GetMapping("/delete/{trainId}")
	public String deletetrain(@PathVariable Long trainId, Model model) {
		adminService.deleteFromId(trainId);
		return "redirect:/admin/viewtrainmaster";
	}

       //delete no of stop
	  @GetMapping("/deletetrain/{id}") 
	  public String deleteShowTrain(@PathVariable Long id, Model model) {
		  adminService.deleteFromtrainid(id);
		  return  "redirect:/admin/viewnoofstop"; 
		  }
	  @GetMapping("/deleteaddingtrain/{trainId}") 
	  public String deletshowTrainPage(@PathVariable Long trainId, Model model) {
			adminService.deleteFromTrainId(trainId);
			return "redirect:/admin/showaddingtrains";
	  }
	  
	  //Update show train
	  @GetMapping(path="/listtrain/update/{trainId}")
	  public String showUpdateTrain(@PathVariable("trainId")long trainId,Model model) {
		  Optional<AddingTrains> temp = addingTrainsRepository.findById(trainId);
		  AddingTrains addingTrains =temp.get();
		  model.addAttribute("addingTrains", addingTrains);
		return "/admin/update_showtrain";
		  
	  }
		@PostMapping("/Saveupdate")
		public String saveUpdateShowTrain(@ModelAttribute("AddingTrains") AddingTrains addingTrains) {
			this.adminService.saveAddTrain(addingTrains);			

			return "/admin/showtrain";
		}
		
	  //Update train master
		@GetMapping(path="/trainmaster/update/{trainId}")
		public String viewUpdateTrain(@PathVariable("trainId")long trainId,Model model) {
			Optional<TrainMaster> train = trainMasterRepository.findById(trainId);
			TrainMaster trainMaster =train.get();
			model.addAttribute("trainMaster", trainMaster);
			return "/admin/update_trainmaster";
			
			
		}
		@PostMapping("/saveupdatetrainmaster")
		public String saveUpdateTrainMaster(@ModelAttribute("TrainMaster") TrainMaster trainMaster) {
			this.adminService.saveTrainMaster(trainMaster);
			return "redirect:/admin/viewtrainmaster";
		}
		//Update for no of stop
		@GetMapping(path="/noofstop/update/{id}")
		public String viewUpdateNoOfStop(@PathVariable("id")long id,Model model) {
			Optional<NoOfStops> detail = noOfStopsRepository.findById(id);
			NoOfStops noOfStops  =detail.get();
			model.addAttribute("noOfStops", noOfStops);
			return "/admin/update_noofstop";
}
		@PostMapping("/saveupdatenoofstop")
		public String saveUpdateNoOfStops(@ModelAttribute("NoOfStops") NoOfStops noOfStops) {
			this.adminService.saveNoOfStops(noOfStops);
			
			return "redirect:/admin/viewnoofstop";
		}
		
	
		
}	

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	