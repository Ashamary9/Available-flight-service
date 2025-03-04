package com.example.Availableflightservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.example.Availableflightservice.model.AvailableFlight;
import com.example.Availableflightservice.repository.AvailableFlightRepo;



@SpringBootTest
class AvailableFlightServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired

	AvailableFlightRepo availableFlightRepo;

	@Test

	@Order(1)

	public void saveAvailableFlight() {

		AvailableFlight flight = new AvailableFlight();

		flight.setFlightNo("76543");
		flight.setFlightName("indigo");
		flight.setFlightFrom("chennai");
		flight.setFlightTo("mumbai");
		flight.setSeats(5);
		flight.setDate("20-10-2023");
		flight.setFare(500);
		flight.setTime("9:30 am");

		AvailableFlight save = availableFlightRepo.save(flight);

		assertNotNull(save);

	}

	@Test

	@Order(2)

	public void cancelBooking() {

		availableFlightRepo.findById("67891");

		assertThat(availableFlightRepo.existsById("67891")).isFalse();

	}

	@Test

	@Order(3)

	public void testUpdate() {

		AvailableFlight flight = availableFlightRepo.findById("98892").get();

		flight.setFlightName("AirIndia");

		availableFlightRepo.save(flight);

		assertNotEquals("Airasia", availableFlightRepo.findById("98892").get().getFlightName());

	}

	@Test

	@Order(4)

	public void getAllBookings() {

		List<AvailableFlight> list = availableFlightRepo.findAll();

		assertThat(list).size().isGreaterThan(0);

	}

	@Test

	@Order(5)

	public void getBookingById() {

		AvailableFlight list = availableFlightRepo.findById("98892").get();

		assertEquals("98892", list.getFlightNo());

	}

}
