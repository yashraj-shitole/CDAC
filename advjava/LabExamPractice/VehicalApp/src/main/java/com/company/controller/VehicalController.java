package com.company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.ApiResponse;
import com.company.dto.VehicalDTO;
import com.company.service.VehicalService;

import jakarta.validation.Valid;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/vehical")
public class VehicalController {
	
//	1) Add new Vehicle. ---------------DONE
//	2) Delete vehicle records for given User. (need to provide User name) ------------------DONE
//	3) Fetch all Vehicle for given User. (need to provide User name) 
//	4) For a given date, get the list of sold vehicle name and their User name. If no vehicle --------------DONE
//	sold for given date return proper response message.
			
	
	@Autowired
	private VehicalService vehicalService;
	
	
	@PostMapping("/")
	public ResponseEntity<?> postMethodName(@RequestBody @Valid VehicalDTO entity) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicalService.addVehical(entity));
	}
	
	@GetMapping("/{date}")
	public ResponseEntity<?> getByUserName(@PathVariable LocalDate date) {
		
		if (vehicalService.getUserByDate(date).isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(LocalDateTime.now(),"No vehical found"));
		}
		
		return ResponseEntity.ok(vehicalService.getUserByDate(date));
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> getAllVehical() {
		
		if (vehicalService.getAllVehical().isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(LocalDateTime.now(),"No vehical found"));
		}
		
		return ResponseEntity.ok(vehicalService.getAllVehical());
	}
	
	
	
	@DeleteMapping("/{username}")
	public ResponseEntity<?> getMethodName(@PathVariable String username) {
		
		
		
		return ResponseEntity.ok(vehicalService.deleteVehical(username));
	}
	
	
	
	

}
