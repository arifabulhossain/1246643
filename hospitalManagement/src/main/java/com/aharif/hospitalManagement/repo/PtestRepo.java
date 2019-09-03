package com.aharif.hospitalManagement.repo;

import com.aharif.hospitalManagement.entity.Ptest;
import com.aharif.hospitalManagement.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PtestRepo extends JpaRepository<Ptest,Long> {
    Ptest findBypName(String pName);
    boolean existsPtestByPName(String pName);


}
