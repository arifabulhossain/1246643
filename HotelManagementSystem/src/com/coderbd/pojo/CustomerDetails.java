/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.pojo;

/**
 *
 * @author User
 */
public class CustomerDetails {

    private int id;
    private String customerName;
    private String fatherOrSpouseName;
    private int age;
    private String occupation;
    private String address;
    private String mobile;

    public CustomerDetails() {
    }

    public CustomerDetails(int id, String customerName, String fatherOrSpouseName, int age, String occupation, String address, String mobile) {
        this.id = id;
        this.customerName = customerName;
        this.fatherOrSpouseName = fatherOrSpouseName;
        this.age = age;
        this.occupation = occupation;
        this.address = address;
        this.mobile = mobile;
    }

    public CustomerDetails(String customerName, String fatherOrSpouseName, int age, String occupation, String address, String mobile) {
        this.customerName = customerName;
        this.fatherOrSpouseName = fatherOrSpouseName;
        this.age = age;
        this.occupation = occupation;
        this.address = address;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFatherOrSpouseName() {
        return fatherOrSpouseName;
    }

    public void setFatherOrSpouseName(String fatherOrSpouseName) {
        this.fatherOrSpouseName = fatherOrSpouseName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
