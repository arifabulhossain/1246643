package com.aharif.hospitalManagement.repo;

import com.aharif.hospitalManagement.entity.Department;
import com.aharif.hospitalManagement.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DrugRepo extends JpaRepository<Drug,Long> {


    Drug findBymName(String mName);
    boolean existsDrugBymName(String mName);

}
