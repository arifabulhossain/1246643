package com.aharif.hospitalManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Chamber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_name", unique = false, nullable = false)
    private String doctorName;

    @Column(name = "phoneNo", unique = false, nullable = false)
    private String phoneNo;

    @Column(name = "email", unique = false, nullable = false)
    private String email;

    @Column(name = "address", unique = false, nullable = false)
    private String address;

    @Column(name = "service", unique = false, nullable = false)
    private String service;

    ////////////////////////////////////////


    public Chamber() {
    }


    ///////////////////////////////////////


    public Chamber(String doctorName, String phoneNo, String email, String address, String service) {
        this.doctorName = doctorName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
        this.service = service;
    }

    ///////////////////////////////////////////


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }


    ///////////////////////////////////////


    @Override
    public String toString() {
        return "Chamber{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", service='" + service + '\'' +
                '}';
    }


    /////////////////////////////////////////////


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chamber chamber = (Chamber) o;
        return Objects.equals(id, chamber.id) &&
                Objects.equals(doctorName, chamber.doctorName) &&
                Objects.equals(phoneNo, chamber.phoneNo) &&
                Objects.equals(email, chamber.email) &&
                Objects.equals(address, chamber.address) &&
                Objects.equals(service, chamber.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorName, phoneNo, email, address, service);
    }

}
