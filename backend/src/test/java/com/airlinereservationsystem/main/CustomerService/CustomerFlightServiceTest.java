package com.airlinereservationsystem.main.CustomerService;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.airlinereservationsystem.main.enums.Seatclass;
import com.airlinereservationsystem.main.exception.InvalidIDException;
import com.airlinereservationsystem.main.model.CustomerFlight;
import com.airlinereservationsystem.main.repository.CustomerFlightRepository;
import com.airlinereservationsystem.main.service.CustomerFlightService;

@ExtendWith(MockitoExtension.class)
public class CustomerFlightServiceTest {
	
	@Mock
    private CustomerFlightRepository customerFlightRepository;

    @InjectMocks
    private CustomerFlightService customerFlightService;
	
	   @Test
	    void testGetMyBookings() {
	        
	        int customerId = 2; 
	        List<CustomerFlight> mockBookings = new ArrayList<>(); 
	        when(customerFlightRepository.getMyBookings(customerId)).thenReturn(mockBookings);

	       
	        List<CustomerFlight> myBookings = customerFlightService.getMyBookings(customerId);

	        
	        assertNotNull(myBookings);
	        
	    }
	

}
