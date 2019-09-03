package com.aharif.hospitalManagement.repo;




import com.aharif.hospitalManagement.entity.Serial;
import com.aharif.hospitalManagement.entity.TestReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestReportRepo  extends JpaRepository<TestReport,Long> {


    TestReport findByTestSample(String testSample);
    boolean existsTestReportByTestSample(String testSample);


}
