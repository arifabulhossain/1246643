package com.aharif.hospitalManagement.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name")
    private String patientName;


    @Column(name = "test_name")
    private String testName;



    @Column(name = "refdoctor_name")
    private String refdoctorName;


    @Column(name = "test_fee")
    private Double testFee;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testDate;

    ////////////////////////////////////////////////////////


    public Test() {

    }


    public Test(String patientName, String testName, String refdoctorName, Double testFee, Date testDate) {
        this.patientName = patientName;
        this.testName = testName;
        this.refdoctorName = refdoctorName;
        this.testFee = testFee;
        this.testDate = testDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getRefdoctorName() {
        return refdoctorName;
    }

    public void setRefdoctorName(String refdoctorName) {
        this.refdoctorName = refdoctorName;
    }

    public Double getTestFee() {
        return testFee;
    }

    public void setTestFee(Double testFee) {
        this.testFee = testFee;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", testName='" + testName + '\'' +
                ", refdoctorName='" + refdoctorName + '\'' +
                ", testFee=" + testFee +
                ", testDate=" + testDate +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(id, test.id) &&
                Objects.equals(patientName, test.patientName) &&
                Objects.equals(testName, test.testName) &&
                Objects.equals(refdoctorName, test.refdoctorName) &&
                Objects.equals(testFee, test.testFee) &&
                Objects.equals(testDate, test.testDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientName, testName, refdoctorName, testFee, testDate);
    }
}
