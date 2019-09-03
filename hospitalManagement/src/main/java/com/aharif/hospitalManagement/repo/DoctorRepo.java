package com.aharif.hospitalManagement.repo;

import com.aharif.hospitalManagement.entity.Doctor;
import com.aharif.hospitalManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Long> {


    //finding by roleNome
    Doctor findByDoctorName(String doctorName);
    boolean existsDoctorByDoctorName(String doctorName);


}
