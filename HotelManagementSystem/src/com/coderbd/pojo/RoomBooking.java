/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.pojo;

import java.sql.Date;

/**
 *
 * @author User
 */
public class RoomBooking {

    private int id;
    private String customer_name;
    // Room room;
    private Date bookingDate;
    private Date checkInDate;
    private Date checkOutDate;
    private int numberOfDays;
    private double perDayAmount;
    private double totaRentAmount;
    // double bookingAmount;
    private double dueAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPerDayAmount() {
        return perDayAmount;
    }

    public void setPerDayAmount(double perDayAmount) {
        this.perDayAmount = perDayAmount;
    }

    public double getTotaRentAmount() {
        return totaRentAmount;
    }

    public void setTotaRentAmount(double totaRentAmount) {
        this.totaRentAmount = totaRentAmount;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public RoomBooking(int id, String customer_name, Date bookingDate, Date checkInDate, Date checkOutDate, int numberOfDays, double perDayAmount, double totaRentAmount, double dueAmount) {
        this.id = id;
        this.customer_name = customer_name;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfDays = numberOfDays;
        this.perDayAmount = perDayAmount;
        this.totaRentAmount = totaRentAmount;
        this.dueAmount = dueAmount;
    }

    public RoomBooking(String customer_name, Date bookingDate, Date checkInDate, Date checkOutDate, int numberOfDays, double perDayAmount, double totaRentAmount, double dueAmount) {
        this.customer_name = customer_name;
        this.bookingDate = bookingDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfDays = numberOfDays;
        this.perDayAmount = perDayAmount;
        this.totaRentAmount = totaRentAmount;
        this.dueAmount = dueAmount;
    }

   


}
