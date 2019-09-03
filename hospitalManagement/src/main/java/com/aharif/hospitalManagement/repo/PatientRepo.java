package com.aharif.hospitalManagement.repo;

import com.aharif.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {


    Patient findByName(String name);
    boolean existsPatientByName(String name);

}
