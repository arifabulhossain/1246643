package com.aharif.hospitalManagement.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name", unique = false, nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "mobile", unique = true)
    private String mobile;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "bloodGroup", nullable = false)
    private String bloodGrop;

@Temporal(TemporalType.TIMESTAMP)
@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date admitDate;
    //////////////////////////////////////////////////////


    public Patient() {
    }


    public Patient(String name, int age, String gender, String mobile, String email, String address, String bloodGrop, Date admitDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.bloodGrop = bloodGrop;
        this.admitDate = admitDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodGrop() {
        return bloodGrop;
    }

    public void setBloodGrop(String bloodGrop) {
        this.bloodGrop = bloodGrop;
    }

    public Date getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", bloodGrop='" + bloodGrop + '\'' +
                ", admitDate=" + admitDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return age == patient.age &&
                Objects.equals(id, patient.id) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(gender, patient.gender) &&
                Objects.equals(mobile, patient.mobile) &&
                Objects.equals(email, patient.email) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(bloodGrop, patient.bloodGrop) &&
                Objects.equals(admitDate, patient.admitDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender, mobile, email, address, bloodGrop, admitDate);
    }
}
