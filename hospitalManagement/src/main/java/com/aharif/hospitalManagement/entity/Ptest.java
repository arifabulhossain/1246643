package com.aharif.hospitalManagement.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Ptest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name")
    private String pName;


    @Column(name = "patient_age")
    private String pAge;


    @Column(name = "patient_phn")
    private String pPhone;

    @Column(name = "test_name")
    private String tName;



    @Column(name = "refdoctor_name")
    private String rName;


    @Column(name = "test_fee")
    private Double tFee;



    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tDate;


    /////////////////////////////////////////////////////////////////


    public Ptest() {
    }


    public Ptest(String pName, String pAge, String pPhone, String tName, String rName, Double tFee, Date tDate) {
        this.pName = pName;
        this.pAge = pAge;
        this.pPhone = pPhone;
        this.tName = tName;
        this.rName = rName;
        this.tFee = tFee;
        this.tDate = tDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpAge() {
        return pAge;
    }

    public void setpAge(String pAge) {
        this.pAge = pAge;
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public Double gettFee() {
        return tFee;
    }

    public void settFee(Double tFee) {
        this.tFee = tFee;
    }

    public Date gettDate() {
        return tDate;
    }

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    @Override
    public String toString() {
        return "Ptest{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", pAge='" + pAge + '\'' +
                ", pPhone='" + pPhone + '\'' +
                ", tName='" + tName + '\'' +
                ", rName='" + rName + '\'' +
                ", tFee=" + tFee +
                ", tDate=" + tDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ptest ptest = (Ptest) o;
        return Objects.equals(id, ptest.id) &&
                Objects.equals(pName, ptest.pName) &&
                Objects.equals(pAge, ptest.pAge) &&
                Objects.equals(pPhone, ptest.pPhone) &&
                Objects.equals(tName, ptest.tName) &&
                Objects.equals(rName, ptest.rName) &&
                Objects.equals(tFee, ptest.tFee) &&
                Objects.equals(tDate, ptest.tDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pName, pAge, pPhone, tName, rName, tFee, tDate);
    }
}
