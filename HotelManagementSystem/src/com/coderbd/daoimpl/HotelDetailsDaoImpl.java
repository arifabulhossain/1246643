/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.daoimpl;

import com.coderbd.connection.CustomDBConnection;
import com.coderbd.dao.HotelDetailsDao;
import com.coderbd.pojo.CustomerDetails;
import com.coderbd.pojo.EmployeeDetails;
import com.coderbd.pojo.HotelDetails;
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
public class HotelDetailsDaoImpl implements HotelDetailsDao {

    Connection conn = CustomDBConnection.getDBConnection();

    public static void main(String[] args) {
        HotelDetailsDaoImpl obj = new HotelDetailsDaoImpl();
        obj.createTable();
    }

    @Override
    public void createTable() {

        String sql = "create table IF NOT EXISTS HotelDetails(id int(5) auto_increment primary key,  hotel_Name varchar(20) unique,address varchar(20),mobile varchar(20), contact_person varchar(20))";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("HotelDetails Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(HotelDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(HotelDetails hd) {
         String sql = "insert into HotelDetails( hotel_Name,address,mobile, contact_person) values(?,?,?,?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1,hd.getHotelName());
            pstm.setString(2,hd.getAddress());
            
            pstm.setString(3, hd.getMobile());
            pstm.setString(4,hd.getContactPerson());
           
           
            pstm.executeUpdate();
            System.out.println("Insert success!");
        } catch (SQLException ex) {
            Logger.getLogger(HotelDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HotelDetails hd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmployeeDetails getHotelDetailsById(int id) {
        return null;
    
    }

    @Override
    public CustomerDetails getHotelDetailsByHotelDetailsCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<HotelDetails> getList() {
      List<HotelDetails> list = new ArrayList();
        String sql = "select * from HotelDetails";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HotelDetails p = new HotelDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    }


