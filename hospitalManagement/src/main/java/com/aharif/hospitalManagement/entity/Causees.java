package com.aharif.hospitalManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Causees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name",  nullable = false)
    private String patientName;

    @Column(name = "disease_name",  nullable = false)
    private String diseaseName;

    @Column(name = "refdoctor_name",  nullable = false)
    private String refdoctorName;

    ////////me////////////////////me//////////////me///////////


    public Causees() {
    }


    public Causees(String patientName, String diseaseName, String refdoctorName) {
        this.patientName = patientName;
        this.diseaseName = diseaseName;
        this.refdoctorName = refdoctorName;
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

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getRefdoctorName() {
        return refdoctorName;
    }

    public void setRefdoctorName(String refdoctorName) {
        this.refdoctorName = refdoctorName;
    }

    @Override
    public String toString() {
        return "Causees{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", diseaseName='" + diseaseName + '\'' +
                ", refdoctorName='" + refdoctorName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Causees causees = (Causees) o;
        return Objects.equals(id, causees.id) &&
                Objects.equals(patientName, causees.patientName) &&
                Objects.equals(diseaseName, causees.diseaseName) &&
                Objects.equals(refdoctorName, causees.refdoctorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientName, diseaseName, refdoctorName);
    }
}
