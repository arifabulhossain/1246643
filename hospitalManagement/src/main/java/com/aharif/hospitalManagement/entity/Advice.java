package com.aharif.hospitalManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private   String patientName;

    private String advices;


    public Advice() {
    }


    public Advice(String patientName, String advices) {
        this.patientName = patientName;
        this.advices = advices;
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

    public String getAdvices() {
        return advices;
    }

    public void setAdvices(String advices) {
        this.advices = advices;
    }


    @Override
    public String toString() {
        return "Advice{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", advices='" + advices + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advice advice = (Advice) o;
        return Objects.equals(id, advice.id) &&
                Objects.equals(patientName, advice.patientName) &&
                Objects.equals(advices, advice.advices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientName, advices);
    }
}
