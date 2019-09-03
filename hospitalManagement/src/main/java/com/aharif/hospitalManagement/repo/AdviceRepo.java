package com.aharif.hospitalManagement.repo;


import com.aharif.hospitalManagement.entity.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceRepo extends JpaRepository<Advice,Long> {

    //finding by roleNome
    Advice findByPatientName(String patientName);
    boolean existsPatientByPatientName(String patientName);

}
