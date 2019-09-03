package com.aharif.hospitalManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dName;


    ////////////////////////////////

    public Designation() {
    }


    ///////////////////////////////


    public Designation(String dName) {
        this.dName = dName;
    }

    /////////////////////


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    ////////////////////


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Designation that = (Designation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dName, that.dName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dName);
    }

    ////////////////////////////////////


    @Override
    public String toString() {
        return "Designation{" +
                "id=" + id +
                ", dName='" + dName + '\'' +
                '}';
    }
}
