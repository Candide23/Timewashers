package com.Timewashers.Repository;

import com.Timewashers.Model.Dryer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DryerRepository extends JpaRepository<Dryer, Long> {
    List<Dryer> findByLaundromatId(Long dryerId);
}
