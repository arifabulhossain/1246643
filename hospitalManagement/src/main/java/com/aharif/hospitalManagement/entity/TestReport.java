package com.aharif.hospitalManagement.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class TestReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    ///////////////////relationship////////////////////////

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

///////////////////////////////////////////////////////////////
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tDate=new Date();




    @Column(name = "test_smple", nullable = false)
    private String testSample;

    @Column(name = "test_result", nullable = false)
    private String testResult;

    @Column(name = "patient_status", nullable = false)
    private String status;

    ////////////////////////////////////////////////////


    public TestReport() {
    }


    public TestReport(Test test, Date tDate, String testSample, String testResult, String status) {
        this.test = test;
        this.tDate = tDate;
        this.testSample = testSample;
        this.testResult = testResult;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Date gettDate() {
        return tDate;
    }

    public  void settDate(Date tDate) {
        this.tDate = tDate;
    }

    public String getTestSample() {
        return testSample;
    }

    public void setTestSample(String testSample) {
        this.testSample = testSample;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "TestReport{" +
                "id=" + id +
                ", test=" + test +
                ", tDate=" + tDate +
                ", testSample='" + testSample + '\'' +
                ", testResult='" + testResult + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestReport that = (TestReport) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(test, that.test) &&
                Objects.equals(tDate, that.tDate) &&
                Objects.equals(testSample, that.testSample) &&
                Objects.equals(testResult, that.testResult) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, test, tDate, testSample, testResult, status);
    }
}
