package com.Timewashers.Service;

import com.Timewashers.Model.Washer;
import com.Timewashers.Repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class WasherService {

    @Autowired
    private WasherRepository washerRepository;

    private List<Washer> washerList = new ArrayList<>(); // Assuming you store washers in memory


    public int getMinutesRemainingForWasher(Long washerId) {
        Washer washer = washerRepository.findById(washerId)
                .orElseThrow(() -> new ResourceNotFoundException("Washer not found with id: " + washerId));

        // Calculate the current time
        Date currentTime = new Date();

        // Calculate the end time of the washer cycle
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(washer.getStartTime());
        calendar.add(Calendar.MINUTE, washer.getDuration());
        Date cycleEndTime = calendar.getTime();

        // Calculate minutes remaining
        long timeDiffMillis = cycleEndTime.getTime() - currentTime.getTime();
        int minutesRemaining = (int) (timeDiffMillis / (60 * 1000)); // Convert milliseconds to minutes

        return Math.max(minutesRemaining, 0); // Ensure non-negative value
    }

    public Washer saveWasher(Washer washer) {
        // Assuming you want to add the washer to an in-memory list
        washerList.add(washer);
        return washer;
    }

    public Washer findWasherById(Long washerId) {
        if (washerList != null) {
            for (Washer washer : washerList) {
                if (washer.getLaundromatId().equals(washerId)) {
                    return washer; // Found the matching washer
                }
            }
        }
        return null; // Washer with the given ID not found
    }

    public boolean isWasherAvailable(Long laundromatId, Long washerId) {
        // Assuming you have a method to find a washer by its ID in the repository
        Washer washer = washerRepository.findWasherById(washerId);

        if (washer != null && washer.getLaundromat().getId().equals(laundromatId)) {
            // Check the availability status of the washer based on your business logic
            return washer.isAvailable();
        }

        // If the washer or laundromat doesn't exist or if the washer is not associated with the laundromat, return false
        return false;
    }
}