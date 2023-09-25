package com.Timewashers.WasherService;

import com.Timewashers.Model.Washer;
import com.Timewashers.Repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class WasherService {

    @Autowired
    private WasherRepository washerRepository;

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
}