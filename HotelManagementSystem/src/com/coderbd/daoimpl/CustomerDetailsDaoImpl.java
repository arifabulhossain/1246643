/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.daoimpl;

import com.coderbd.connection.CustomDBConnection;
import com.coderbd.dao.CustomerDetailsDao;
import com.coderbd.pojo.CustomerDetails;
import java.sql.Connection;
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
public class CustomerDetailsDaoImpl implements CustomerDetailsDao {
 Connection conn = CustomDBConnection.getDBConnection();

  
    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS CustomerDetails(id int(11) auto_increment primary key, customer_name varchar(50), fatherOrSpouse_name varchar(30),age int(11), occupation  varchar(30),address varchar(30), mobile varchar(30))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println(" CustomerDetails Table Created!!");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(CustomerDetails cd) {
         String sql = "insert into CustomerDetails(customer_name,fatherOrSpouse_name,age,occupation,address,mobile) values(?,?,?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, cd.getCustomerName());
            pstm.setString(2, cd.getFatherOrSpouseName());
            pstm.setInt(3, cd.getAge());
            pstm.setString(4, cd.getOccupation());
            pstm.setString(5,cd.getAddress());
            pstm.setString(6, cd.getMobile());
           
            pstm.executeUpdate();
            System.out.println("Insert success!");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(CustomerDetails cd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDetails getCustomerDetailsById(int id) {
     
       CustomerDetails customer = null;
        String sql = "select * from CustomerDetails where id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                /*
                CustomerDetails(String customerName, String fatherOrSpouseName, int age, String occupation,
                String address, String mobile) {
        
                */
                customer = new CustomerDetails(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),
                        rs.getString(5),rs.getString(id));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
        
    }

    @Override
    public CustomerDetails getCustomerDetailsByCustomerDetailsCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CustomerDetails> getList() {
       List<CustomerDetails> list = new ArrayList();
        String sql = "select * from customerdetails";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CustomerDetails p = new CustomerDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    }
    

