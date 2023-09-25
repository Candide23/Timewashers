package com.Timewashers.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "washer")
@Data
public class Washer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laundromat_id")
    private Long laundromatId;
    private String name;
    private boolean isAvailable;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime; // Timestamp when the washer cycle started

    private int duration;


}
