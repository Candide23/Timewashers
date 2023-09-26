package com.Timewashers.Service;

import com.Timewashers.Model.Laundromat;
import com.Timewashers.Repository.LaundromatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaundromatService {

    @Autowired
    LaundromatRepository laundromatRepository;


    public static Laundromat findLaundromatById(Long laundromatId) {
        // Use the repository to find a laundromat by its ID
        Optional<Laundromat> laundromatOptional = laundromatRepository.findById(laundromatId);

        // Check if the laundromat exists
        if (laundromatOptional.isPresent()) {
            return laundromatOptional.get(); // Return the laundromat if found
        } else {
            return null; // Return null if laundromat is not found
        }
    }
}
