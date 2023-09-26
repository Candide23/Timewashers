package com.Timewashers.Repository;


import com.Timewashers.Model.Washer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WasherRepository extends JpaRepository<Washer, Long> {

    List<Washer> findByLaundromatId(Long washerId);

}
