package com.aharif.hospitalManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "doctor_name",  nullable = false)
    private String doctorName;

    @Column(name = "deprtment_name", nullable = false)
    private String departmentName;


  /////////////////////////////


    public Department() {
    }


    /////////////////////////////


    public Department(String doctorName, String departmentName) {
        this.doctorName = doctorName;
        this.departmentName = departmentName;
    }


    ///////////////////////////////////


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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /////////////////////////////////


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }


    ///////////////////////////////////


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctorName, departmentName);
    }
}
