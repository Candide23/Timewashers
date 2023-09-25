package com.Timewashers.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "dryer")
@Data
public class Dryer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laundromatId;
    private String name;
    private boolean isAvailable;
}
