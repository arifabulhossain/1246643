package com.aharif.hospitalManagement.repo;

import com.aharif.hospitalManagement.entity.Patient;
import com.aharif.hospitalManagement.entity.Serial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SerialRepo extends JpaRepository<Serial,Long> {

    Serial findBySerialNo(int serialNo);
    boolean existsSerialBySerialNo(int serialNo);
}
