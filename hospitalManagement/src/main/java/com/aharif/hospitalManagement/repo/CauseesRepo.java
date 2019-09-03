package com.aharif.hospitalManagement.repo;

import com.aharif.hospitalManagement.entity.Causees;
import com.aharif.hospitalManagement.entity.Chamber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CauseesRepo extends JpaRepository<Causees,Long> {


    Causees findBydiseaseName(String diseaseName);
    boolean existsCauseesByDiseaseName(String diseaseName);

}
