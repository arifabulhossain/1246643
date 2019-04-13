/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.pojo;

import java.sql.Date;
import java.sql.SQLXML;

/**
 *
 * @author User
 */
public class Summary {

    private int id;
    // private Room room;
    private String customer_name;
    private Double total_amount;
    private Double paid_amount;
    private Double due_amount;
    private Date add_date;

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

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public Double getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(Double paid_amount) {
        this.paid_amount = paid_amount;
    }

    public Double getDue_amount() {
        return due_amount;
    }

    public void setDue_amount(Double due_amount) {
        this.due_amount = due_amount;
    }

    public Date getAdd_date() {
        return add_date;
    }

    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }

    public Summary(int id, String customer_name, Double total_amount, Double paid_amount, Double due_amount, Date add_date) {
        this.id = id;
        this.customer_name = customer_name;
        this.total_amount = total_amount;
        this.paid_amount = paid_amount;
        this.due_amount = due_amount;
        this.add_date = add_date;
    }

    public Summary(String customer_name, Double total_amount, Double paid_amount, Double due_amount, Date add_date) {
        this.customer_name = customer_name;
        this.total_amount = total_amount;
        this.paid_amount = paid_amount;
        this.due_amount = due_amount;
        this.add_date = add_date;
    }

}
