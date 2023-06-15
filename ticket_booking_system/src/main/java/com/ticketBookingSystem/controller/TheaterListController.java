package com.ticketBookingSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ticketBookingSystem.entity.TheaterListEntity;
import com.ticketBookingSystem.service.TheaterListService;

@Controller
public class TheaterListController {
	
	private TheaterListService theaterListService;

	public TheaterListController(TheaterListService theaterListService) {
		super();
		this.theaterListService = theaterListService;
	}
	
//List Theater
	@GetMapping("/theaters")
	public String listTheater(Model model) {
		model.addAttribute("theatersList", theaterListService.getAllTheaterList());
		return "Index";
	}
	
	@GetMapping("/theaters/addtheater")
	public String addTheaterForm(Model model) {
		TheaterListEntity theaterList= new TheaterListEntity();  //object to hold the form data
		model.addAttribute("theater", theaterList);
		return "AddTheater";
	}
	

// save data and return to list page	
	@PostMapping("/theaters1")
    public String saveProduct(@RequestParam("file") MultipartFile file,
    		@RequestParam("tName") String theaterName, @RequestParam("tType") String theaterType,
    		@RequestParam("city") String city, @RequestParam("address") String address)
    {
		theaterListService.saveTheater(file, theaterName, theaterType, city, address);
    	return "redirect:/theaters";
    }
    
// delete
		@GetMapping("/theater/{id}")
		public String deleteStudent(@PathVariable int id) {
			theaterListService.deleteTheater(id);
			return "redirect:/theaters";
		}

// get	
		@GetMapping("/edittheater/{id}")
		public String editTheater(@PathVariable int id, Model model) {
			model.addAttribute("theater", theaterListService.getTheater(id));
			return "EditTheater";
		}
		
		
		@PostMapping("/theater/{id}")
		public String updateTheater(@PathVariable int id, @RequestParam("file") MultipartFile file,
		        @RequestParam("theaterName") String theaterName, @RequestParam("theaterType") String theaterType,
		        @RequestParam("city") String city, @RequestParam("address") String address) {
		    theaterListService.updateTheater(id, file, theaterName, theaterType, city, address);
		    return "redirect:/theaters";
		}


	
		@GetMapping("/login")
		public String loginForm() {
		    return "Login";
		}
		
	@GetMapping("/signup")
	public String signinForm() {
		return "Signup";
	}
	
}
