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
public class HotelDetails {
    int id;
    String hotelName;
    String address;
    String mobile;
    String contactPerson;

    public HotelDetails() {
    }

    public HotelDetails(int id) {
        this.id = id;
    }

    public HotelDetails(int id, String hotelName, String address, String mobile, String contactPerson) {
        this.id = id;
        this.hotelName = hotelName;
        this.address = address;
        this.mobile = mobile;
        this.contactPerson = contactPerson;
    }

    public HotelDetails(String hotelName, String address, String mobile, String contactPerson) {
        this.hotelName = hotelName;
        this.address = address;
        this.mobile = mobile;
        this.contactPerson = contactPerson;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
    
    
}
