package com.aharif.hospitalManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Attendant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attendant_name", nullable = false)
    private String attendantName;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userRegistration;

///////////////////////////////////////////////////////

    public Attendant() {
    }

    public Attendant(String attendantName, Doctor doctor, User userRegistration) {
        this.attendantName = attendantName;
        this.doctor = doctor;
        this.userRegistration = userRegistration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttendantName() {
        return attendantName;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public User getUserRegistration() {
        return userRegistration;
    }

    public void setUserRegistration(User userRegistration) {
        this.userRegistration = userRegistration;
    }


    @Override
    public String toString() {
        return "Attendant{" +
                "id=" + id +
                ", attendantName='" + attendantName + '\'' +
                ", doctor=" + doctor +
                ", userRegistration=" + userRegistration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendant attendant = (Attendant) o;
        return Objects.equals(id, attendant.id) &&
                Objects.equals(attendantName, attendant.attendantName) &&
                Objects.equals(doctor, attendant.doctor) &&
                Objects.equals(userRegistration, attendant.userRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, attendantName, doctor, userRegistration);
    }
}
