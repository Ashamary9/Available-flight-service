package com.example.Availableflightservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Availableflightservice.exception.FlightNotFoundException;
import com.example.Availableflightservice.model.AvailableFlight;
import com.example.Availableflightservice.service.AvailableFlightService;
import com.example.Availableflightservice.serviceimpl.AvailableFlightServiceImpl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "http://localhost:4200")
public class AvailableFlightController {
	
	@Autowired
	 AvailableFlightService availableFlightService;
	
	
	@PostMapping("/addflight")
	public ResponseEntity<AvailableFlight> addFlightModel(@RequestBody @Valid AvailableFlight flight) throws FlightNotFoundException {
		log.info("Inside the addFlightModel method of Controller");
		log.info("Adding the Flight Details "+flight);
		return ResponseEntity.ok(availableFlightService.addAvailableFlight(flight));
	}
	
	@GetMapping("/viewallflights")
	public ResponseEntity<List<AvailableFlight>> getAllFlights()throws FlightNotFoundException {
		log.info("Inside the getAllFlights method of Controller");
		log.info("Retrieving Flights Data ");
		return ResponseEntity.ok(availableFlightService.getAllAvailableFlights());
	}
	@GetMapping("viewflightbyflightNo/{flightNo}")
	public ResponseEntity<AvailableFlight> getFlightByNo(@PathVariable String flightNo)throws FlightNotFoundException {
		log.info("Inside the getFlightById method of Controller");
		log.info("Retrieving Flight by FlightNo");
		return ResponseEntity.ok(availableFlightService.getFlightById(flightNo));
	}
	@DeleteMapping("/deleteflight/{flightNo}")
	public ResponseEntity<String> deleteFlight(@PathVariable String flightNo) throws FlightNotFoundException {
		log.info("Inside the deleteFlight method of Controller");
		log.info("Delete Flight by FlightNo");
		return ResponseEntity.ok(availableFlightService.deleteFlight(flightNo));
	}
	@GetMapping("/findbetween/{flightFrom}/{flightTo}/{date}")
	public ResponseEntity<List<AvailableFlight>> findByLocation(@PathVariable String flightFrom, @PathVariable String flightTo, @PathVariable String date) throws FlightNotFoundException{
		log.info("Inside the findByLocation method of Controller");
		log.info("Retrieving Flights by Destination ");
		return ResponseEntity.ok(availableFlightService.findByLocation(flightFrom,flightTo,date));
	}
	@GetMapping("/viewflightbyname/{flightName}")
	public ResponseEntity<List<AvailableFlight>> getFlightsbyname(@PathVariable("flightName") String flightName) throws FlightNotFoundException {
		log.info("Inside the getFlightsbyname method of Controller");
		log.info("Retrieving Flights by FlightName ");
		return ResponseEntity.ok(availableFlightService.getFlightsbyname(flightName));		
	}
	@PutMapping("/updateflightbyid/{flightNo}")
	public ResponseEntity<AvailableFlight> updateFlight(@PathVariable String flightNo,@RequestBody AvailableFlight flight) throws FlightNotFoundException {
		log.info("Existing data has been updated");
		return ResponseEntity.ok(availableFlightService.updateFlight(flightNo, flight));
	}

}
