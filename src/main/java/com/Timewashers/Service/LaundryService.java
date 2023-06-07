package com.Timewashers.Service;

import com.Timewashers.Model.Machine;
import com.Timewashers.Model.MachineStatus;
import com.Timewashers.Repository.MachineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LaundryService {

    @Autowired
    private final MachineRepository machineRepository;

    public LaundryService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public List<Machine> getMachineStatus() {
        return machineRepository.findAll();
    }

    public boolean startMachine(Long machineId) {
        Optional<Machine> machineOptional = machineRepository.findById(machineId);
        if (machineOptional.isPresent()) {
            Machine machine = machineOptional.get();
            if (!machine.isInUse()) {
                machine.setInUse(true);
                machine.setRemainingTime(60); // Set initial remaining time in minutes
                machineRepository.save(machine);
                return true;
            }
        }
        return false;
    }

    public boolean stopMachine(Long machineId) {
        Optional<Machine> machineOptional = machineRepository.findById(machineId);
        if (machineOptional.isPresent()) {
            Machine machine = machineOptional.get();
            if (machine.isInUse()) {
                machine.setInUse(false);
                machine.setRemainingTime(0);
                machineRepository.save(machine);
                return true;
            }
        }
        return false;
    }


}
