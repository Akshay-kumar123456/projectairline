package com.airlinereservationsystem.main.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airlinereservationsystem.main.enums.Role;
import com.airlinereservationsystem.main.model.Executive;
import com.airlinereservationsystem.main.model.User;
import com.airlinereservationsystem.main.service.ExecutiveService;
import com.airlinereservationsystem.main.service.UserService;

@RestController
@RequestMapping("/executive")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ExecutiveController {
	@Autowired
	private ExecutiveService executiveService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private Logger logger;
	
	
	//localhost:8081/executive/add
/*
   {
"name":"akshy",
"email":"akshy123@gmail.com",
"user":{
        "username":"akshy",
        "password":"akshy@123"
       }
   }
*/
	@PostMapping("/add") // adding new Executive
	public Executive addExecucutive(@RequestBody Executive executive) {
		 
		User user = executive.getUser();
		String passwordPlain =user.getPassword();
		String encodedPassword =passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
		user.setRole(Role.EXECUTIVE);
		user=userService.insert(user);
		executive.setUser(user);
		return executiveService.insert(executive);
		
	}
	
	
	//localhost:8081/executive/totalairlines
	@GetMapping("/totalairlines")
    public ResponseEntity<Long> getTotalAirlines() {
        long totalAirlines = executiveService.getTotalAirlines();
        return ResponseEntity.ok(totalAirlines);
    }

    //localhost:8081/executive/totalusers
    @GetMapping("/totalusers")
    public ResponseEntity<Long> getTotalUsers() {
        long totalUsers = executiveService.getTotalUsers();
        return ResponseEntity.ok(totalUsers);
    }

    //localhost:8081/executive/totalfeedbacks
    @GetMapping("/totalfeedbacks") // Gets total number of feedbacks given
    public ResponseEntity<Long> getTotalFeedbacks() {
        long totalFeedbacks = executiveService.getTotalFeedbacks();
        return ResponseEntity.ok(totalFeedbacks);
    }

}
