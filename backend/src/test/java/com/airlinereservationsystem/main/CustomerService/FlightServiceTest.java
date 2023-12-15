package com.airlinereservationsystem.main.CustomerService;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.airlinereservationsystem.main.exception.InvalidIDException;
import com.airlinereservationsystem.main.model.Flight;
import com.airlinereservationsystem.main.repository.FlightRepository;
import com.airlinereservationsystem.main.service.FlightService;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {
	@Mock
	private FlightRepository flightRepository;
	
	@InjectMocks
	private FlightService flightService; 
	
	
	 @Test
	 void getbyid() throws InvalidIDException {
		  int id =4;
		  Flight mockflight = new Flight();
		  when(flightRepository.findById(id)).thenReturn(Optional.of(mockflight ));
		  
		  Flight flight =flightService.getById(id);
		  
		  
		  assertNotNull(flight);
		  
	 }
	
	
	
	
	
	

}
