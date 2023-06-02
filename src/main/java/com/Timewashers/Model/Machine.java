package com.Timewashers.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "machines")
@Data
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private boolean inUse;

    private int remainingTime;
}
