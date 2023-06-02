package com.Timewashers.Controllers;


import com.Timewashers.Model.Machine;
import com.Timewashers.Model.MachineStatus;
import com.Timewashers.Service.LaundryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LaundryController {

    @Autowired
    private final LaundryService laundryService;

    public LaundryController(LaundryService laundryService) {
        this.laundryService = laundryService;
    }

    // Endpoint to retrieve available washers and dryers
    @GetMapping("/machines")
    public List<Machine> getMachineStatus() {
        return laundryService.getMachineStatus();
    }

    // Endpoint to start a washer or dryer
    @PostMapping("/machines/{machineId}/start")
    public ResponseEntity<String> startMachine(@PathVariable("machineId") Long machineId) {
        boolean started = laundryService.startMachine(machineId);
        if (started) {
            return ResponseEntity.ok("Machine started successfully");
        } else {
            return ResponseEntity.badRequest().body("Machine is already in use");
        }
    }

    // Endpoint to stop a washer or dryer
    @PostMapping("/machines/{machineId}/stop")
    public ResponseEntity<String> stopMachine(@PathVariable("machineId") Long machineId) {
        boolean stopped = laundryService.stopMachine(machineId);
        if (stopped) {
            return ResponseEntity.ok("Machine stopped successfully");
        } else {
            return ResponseEntity.badRequest().body("Machine is not in use");
        }
    }
}
