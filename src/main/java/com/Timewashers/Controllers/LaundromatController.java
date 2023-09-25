package com.Timewashers.Controllers;

import com.Timewashers.Model.Laundromat;
import com.Timewashers.Repository.LaundromatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/laundromats")
public class LaundromatController {

    @Autowired
    private LaundromatRepository laundromatRepository;

    @GetMapping
    public List<Laundromat> getAllLaundromats() {
        return laundromatRepository.findAll();
    }

    @GetMapping("/{id}")
    public Laundromat getLaundromatById(@PathVariable Long id) {
        return laundromatRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Laundromat not found with id: " + id));
    }

    // You can implement other CRUD operations for laundromats here.
}





