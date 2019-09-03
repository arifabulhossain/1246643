package com.aharif.hospitalManagement.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "patient_name",  nullable = false)
    private String pName;

    @Column(name = "medicine_name",  nullable = false)
    private String mName;

    @Column(name = "medicine_group",  nullable = false)
    private String medicineGroup;


/////////me//////////me/////////////me/////////////


    public Drug() {
    }

    public Drug(String pName, String mName, String medicineGroup) {
        this.pName = pName;
        this.mName = mName;
        this.medicineGroup = medicineGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getMedicineGroup() {
        return medicineGroup;
    }

    public void setMedicineGroup(String medicineGroup) {
        this.medicineGroup = medicineGroup;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", mName='" + mName + '\'' +
                ", medicineGroup='" + medicineGroup + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return Objects.equals(id, drug.id) &&
                Objects.equals(pName, drug.pName) &&
                Objects.equals(mName, drug.mName) &&
                Objects.equals(medicineGroup, drug.medicineGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pName, mName, medicineGroup);
    }
}
