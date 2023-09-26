package com.Timewashers.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "laundromat")
@Data
public class Laundromat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laundromatId;
    private String name;


    private List<Washer> washers; // Assuming you have a list of washers



    public Washer findWasherById(Long washerId) {
        if (washers != null) {
            for (Washer washer : washers) {
                if (washer.getLaundromatId().equals(washerId)) {
                    return washer; // Found the matching washer
                }
            }
        }
        return null; // Washer with the given ID not found
    }
}
