package com.aharif.hospitalManagement.repo;



import com.aharif.hospitalManagement.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository <Test,Long> {
    Test findBytestName(String testName);
    boolean existsTestByTestName(String testName);
    
}
