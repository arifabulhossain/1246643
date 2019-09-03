package com.aharif.hospitalManagement.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

////////////////////relationship////////////////////////

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User userRegistration;


    @OneToOne
    @JoinColumn(name = "chamber_id")
    private Chamber chamber;

    ////////////////////////////////////////



    /////////////////////////////////////////////////


    @Column(name = "doctor_name",  nullable = false)
    private String doctorName;

    @Column(name = "room_no",  nullable = false)
    private int roomNo;

    @Column(name = "offday_name", nullable = false)
    private String offDay;


    @Column(name = "schedule_time", nullable = false)
    private String scheduleTime;

    @Column(name = "fee", nullable = false)
    private double doctorFee;


//setter and getter and constictor


    public Doctor() {
    }

    public Doctor(Department department, Designation designation, User userRegistration, Chamber chamber, Set<User> users, Set<Department> dpts, Set<Designation> dsgn, Set<Chamber> chambers, String doctorName, int roomNo, String offDay, String scheduleTime, double doctorFee) {
        this.department = department;
        this.designation = designation;
        this.userRegistration = userRegistration;
        this.chamber = chamber;

        this.doctorName = doctorName;
        this.roomNo = roomNo;
        this.offDay = offDay;
        this.scheduleTime = scheduleTime;
        this.doctorFee = doctorFee;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    public User getUserRegistration() {
        return userRegistration;
    }

    public void setUserRegistration(User userRegistration) {
        this.userRegistration = userRegistration;
    }

    public Chamber getChamber() {
        return chamber;
    }

    public void setChamber(Chamber chamber) {
        this.chamber = chamber;
    }


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getOffDay() {
        return offDay;
    }

    public void setOffDay(String offDay) {
        this.offDay = offDay;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public double getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(double doctorFee) {
        this.doctorFee = doctorFee;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", department=" + department +
                ", designation=" + designation +
                ", userRegistration=" + userRegistration +
                ", chamber=" + chamber +

                ", doctorName='" + doctorName + '\'' +
                ", roomNo=" + roomNo +
                ", offDay='" + offDay + '\'' +
                ", scheduleTime='" + scheduleTime + '\'' +
                ", doctorFee=" + doctorFee +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return roomNo == doctor.roomNo &&
                Double.compare(doctor.doctorFee, doctorFee) == 0 &&
                Objects.equals(id, doctor.id) &&
                Objects.equals(department, doctor.department) &&
                Objects.equals(designation, doctor.designation) &&
                Objects.equals(userRegistration, doctor.userRegistration) &&

                Objects.equals(doctorName, doctor.doctorName) &&
                Objects.equals(offDay, doctor.offDay) &&
                Objects.equals(scheduleTime, doctor.scheduleTime);
    }


}
