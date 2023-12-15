package com.airlinereservationsystem.main.CustomerService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.airlinereservationsystem.main.exception.InvalidIDException;
import com.airlinereservationsystem.main.model.Route;
import com.airlinereservationsystem.main.repository.RouteRepository;
import com.airlinereservationsystem.main.service.RouteService;

@ExtendWith(MockitoExtension.class)
class RouteServiceTest {

    @Mock
    private RouteRepository routeRepository;

    @InjectMocks
    private RouteService routeService;

    @Test
    void testInsertRoute() {
        
        Route routeToInsert = new Route(); 
        when(routeRepository.save(routeToInsert)).thenReturn(routeToInsert);

        
        Route insertedRoute = routeService.insert(routeToInsert);

        
        assertNotNull(insertedRoute);
       
    }

    @Test
    void testGetRouteById() throws InvalidIDException {
        
        int routeId = 1;
        Route mockRoute = new Route(); 
        when(routeRepository.findById(routeId)).thenReturn(Optional.of(mockRoute));

       
        Route retrievedRoute = routeService.getRoute(routeId);

       
        assertNotNull(retrievedRoute);
        
    }

    @Test
    void testGetAllRoutes() {
       
        List<Route> mockRoutes = new ArrayList<>();
        when(routeRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(mockRoutes));

       
        List<Route> allRoutes = routeService.getAll(mock(Pageable.class));

       
        assertNotNull(allRoutes);
       
    }

    @Test
    void testGetRouteBySourceAndDestination() throws InvalidIDException {
       
        String source = "Mumbai"; 
        String destination = "Chennai"; 
        Route mockRoute = new Route(); 
        when(routeRepository.getRoute(source, destination)).thenReturn(Optional.of(mockRoute));

       
        Route retrievedRoute = routeService.getidbySD(source, destination);

        
        assertNotNull(retrievedRoute);
        
    }
}
