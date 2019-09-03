package com.aharif.hospitalManagement.repo;

import com.aharif.hospitalManagement.entity.Department;
import com.aharif.hospitalManagement.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepo extends JpaRepository<Designation,Long> {

    Designation findByDName(String dName);
    boolean existsDesignationBydName(String dName);


}
