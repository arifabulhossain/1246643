/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.daoimpl;

import com.coderbd.connection.CustomDBConnection;
import com.coderbd.dao.EmployeeDetailsDao;
import com.coderbd.pojo.EmployeeDetails;
import com.coderbd.pojo.HotelDetails;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class EmployeeDetailsDaoImpl implements EmployeeDetailsDao {
 Connection conn = CustomDBConnection.getDBConnection();

    public static void main(String[] args) {
        EmployeeDetailsDaoImpl edi = new EmployeeDetailsDaoImpl();
        edi.createTable();
    }
    @Override
    public void createTable() {
       String sql = "create table IF NOT EXISTS EmployeeDetails(id int(11) auto_increment primary key,emp_name varchar(20), date Date,mobile varchar(30),hotel_Details varchar(30),joining_date date,  hotel_Name varchar(30),FOREIGN KEY (hotel_Name) REFERENCES HotelDetails(hotel_Name))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println(" EmployeeDetails Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    @Override
    public void save(EmployeeDetails ed) {
        HotelDetails hotelDetails = new HotelDetails();
       String sql = "insert into EmployeeDetails(emp_name varchar(20), date Date,mobile varchar(30),hotel_Details varchar(30),joining_date date,  hotel_Name varchar(30),FOREIGN KEY (hotel_Name) REFERENCES HotelDetails(hotel_Name)) values(?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, ed.getName());
            pstm.setDate(2, (Date) ed.getDate());
            pstm.setString(3, ed.getMobile());
            pstm.setDate(4, (Date) ed.getJoiningDate());
            pstm.setString(5, ed.HotelDetails(hotelDetails));
           
            pstm.executeUpdate();
            System.out.println("Insert success!");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(EmployeeDetails ed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmployeeDetails getEmployeeDetailsById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmployeeDetails getEmployeeDetailsByEmployeeDetailsCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmployeeDetails> getList() {
    
       List<EmployeeDetails> list = new ArrayList();
        String sql = "select * from EmployeeDetails";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                /*
                EmployeeDetails(String name, Date date, String address, String mobile,
                HotelDetails hotelDetails, Date joiningDate)
     
                */
                EmployeeDetails p = new EmployeeDetails(rs.getString(1), rs.getDate(2), 
                        rs.getString(3),rs.getString(4),new HotelDetails(rs.getInt(5)),rs.getDate(6));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    }
    

