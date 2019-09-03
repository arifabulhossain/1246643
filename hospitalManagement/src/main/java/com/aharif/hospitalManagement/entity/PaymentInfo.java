package com.aharif.hospitalManagement.entity;



import javax.persistence.*;
import java.util.Date;

@Entity
public class PaymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //private TestType testType;
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    private double feeAmount;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    ///////////////////////////////////////////////////////////////////////////////////////////


    public PaymentInfo() {
    }


    public PaymentInfo(Date paymentDate, double feeAmount, Doctor doctor, Patient patient) {
        this.paymentDate = paymentDate;
        this.feeAmount = feeAmount;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
