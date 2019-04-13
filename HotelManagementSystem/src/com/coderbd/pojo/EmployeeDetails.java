/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.pojo;

import java.util.Date;

/**
 *
 * @author User
 */
public class EmployeeDetails {
    int id;
    String name;
    Date date;
    String address;
    String mobile;
    HotelDetails hotelDetails;
    Date joiningDate;

    public EmployeeDetails() {
    }

    public EmployeeDetails(int id, String name, Date date, String address, String mobile, HotelDetails hotelDetails, Date joiningDate) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
        this.mobile = mobile;
        this.hotelDetails = hotelDetails;
        this.joiningDate = joiningDate;
    }

    public EmployeeDetails(String name, Date date, String address, String mobile, HotelDetails hotelDetails, Date joiningDate) {
        this.name = name;
        this.date = date;
        this.address = address;
        this.mobile = mobile;
        this.hotelDetails = hotelDetails;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public HotelDetails getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(HotelDetails hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String HotelDetails(HotelDetails hotelDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getCustomerName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getFatherOrSpouseName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getAge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getOccupation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
