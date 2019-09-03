package com.aharif.hospitalManagement.repo;

import com.aharif.hospitalManagement.entity.Chamber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChamberRepo extends JpaRepository<Chamber,Long> {

    Chamber findBydoctorName(String doctorName);
    boolean existsChamberByDoctorName(String doctorName);
}
