package com.aharif.hospitalManagement.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Serial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int serialNo;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Temporal(TemporalType.TIMESTAMP)
    private Date appoinmentDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "chamber_id")
    private Chamber chamber;



    ///////////////////////////////////////////////////////////////


    public Serial() {
    }


    public Serial(int serialNo, Patient patient, Date appoinmentDate, Doctor doctor, Chamber chamber) {
        this.serialNo = serialNo;
        this.patient = patient;
        this.appoinmentDate = appoinmentDate;
        this.doctor = doctor;
        this.chamber = chamber;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getAppoinmentDate() {
        return appoinmentDate;
    }

    public void setAppoinmentDate(Date appoinmentDate) {
        this.appoinmentDate = appoinmentDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Chamber getChamber() {
        return chamber;
    }

    public void setChamber(Chamber chamber) {
        this.chamber = chamber;
    }

    @Override
    public String toString() {
        return "Serial{" +
                "id=" + id +
                ", serialNo=" + serialNo +
                ", patient=" + patient +
                ", appoinmentDate=" + appoinmentDate +
                ", doctor=" + doctor +
                ", chamber=" + chamber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serial serial = (Serial) o;
        return serialNo == serial.serialNo &&
                Objects.equals(id, serial.id) &&
                Objects.equals(patient, serial.patient) &&
                Objects.equals(appoinmentDate, serial.appoinmentDate) &&
                Objects.equals(doctor, serial.doctor) &&
                Objects.equals(chamber, serial.chamber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serialNo, patient, appoinmentDate, doctor, chamber);
    }


}
