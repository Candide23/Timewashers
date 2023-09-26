package com.Timewashers.Controllers;

import com.Timewashers.Model.Washer;
import com.Timewashers.Model.WasherAvailabilityResponse;
import com.Timewashers.Repository.WasherRepository;
import com.Timewashers.Service.WasherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/washers")
public class WasherController {

    @Autowired
    private WasherService washerService;

    @Autowired
    private WasherRepository washerRepository;

    @GetMapping
    public List<Washer> getAllWashers() {
        return washerRepository.findAll();
    }

    @GetMapping("/by-laundromat/{laundromatId}")
    public List<Washer> getWashersByLaundromat(@PathVariable Long laundromatId) {
        return washerRepository.findByLaundromatId(laundromatId);
    }

    @GetMapping("/{id}")
    public Washer getWasherById(@PathVariable Long id) {
        return washerRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Washer not found with id: " + id));
    }

    // Endpoint to get the availability status of a washer
    @GetMapping("/{washerId}/availability")
    public ResponseEntity<WasherAvailabilityResponse> getWasherAvailability(@PathVariable Long washerId) {
        int minutesRemaining = washerService.getMinutesRemainingForWasher(washerId);

        boolean isWasherAvailable = washerService.isWasherAvailable(washerId);


        WasherAvailabilityResponse response = new WasherAvailabilityResponse(minutesRemaining, washerId, isWasherAvailable);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // You can implement other CRUD operations for washers here.
}
