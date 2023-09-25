package com.Timewashers.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "laundromat")
@Data
public class Laundromat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laundromatId;
    private String name;
}
