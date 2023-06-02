package com.Timewashers.Model;

import lombok.Data;

@Data
public class MachineStatus {

    private Long id;
    private String type;
    private boolean inUse;
    private int remainingTime;

}
