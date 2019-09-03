package com.aharif.hospitalManagement.repo;


import com.aharif.hospitalManagement.entity.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendantRepo extends JpaRepository<Attendant,Long> {

    Attendant findByAttendantName(String attendantName);
    boolean existsAttendantByAttendantName(String attendantName);


}
