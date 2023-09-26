package com.Timewashers.Controllers;

import com.Timewashers.Model.Laundromat;
import com.Timewashers.Model.Washer;
import com.Timewashers.Model.WasherAvailabilityResponse;
import com.Timewashers.Repository.LaundromatRepository;
import com.Timewashers.Service.LaundromatService;
import com.Timewashers.Service.WasherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laundromats")
public class LaundromatController {

    @Autowired
    private LaundromatRepository laundromatRepository;

    @Autowired
    LaundromatService laundromatService;

    @Autowired
    private WasherService washerService;


    @GetMapping("/{id}")
    public Laundromat getLaundromatById(@PathVariable Long id) {
        return laundromatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Laundromat not found with id: " + id));
    }

    @PutMapping("/{laundromatId}/washers/{washerId}")
    public ResponseEntity<Void> updateWasherAvailability(
            @PathVariable Long laundromatId,
            @PathVariable Long washerId,
            @RequestBody WasherAvailabilityResponse request) {
        // 1. Find the Laundromat (Assuming you have a LaundromatService)
        Laundromat laundromat = LaundromatService.findLaundromatById(laundromatId);
        if (laundromat == null) {
            return ResponseEntity.notFound().build();
        }

        // 2. Find the Washer within the Laundromat
        //Washer washer = laundromat.findWasherById(washerId);
        Washer washer = laundromat.findWasherById(washerId);

        if (washer == null) {
            return ResponseEntity.notFound().build();
        }

        // 3. Update Washer Availability
        boolean newAvailability = request.isAvailable();
        washer.setAvailable(newAvailability);

        // 4. Save the Updated Washer
        washerService.saveWasher(washer); // Assuming you have a WasherService

        // Return a 204 No Content response indicating success
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Laundromat> getAllLaundromats() {
        return laundromatRepository.findAll();
    }



    // You can implement other CRUD operations for laundromats here.
}





