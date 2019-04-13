/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.daoimpl;

import com.coderbd.connection.CustomDBConnection;
import com.coderbd.dao.RoomTypeDao;
import com.coderbd.pojo.CustomerDetails;
import com.coderbd.pojo.RoomType;
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
public class RoomTypeDaoImpl implements RoomTypeDao{
     Connection conn = CustomDBConnection.getDBConnection();

    public static void main(String[] args) {
        RoomTypeDaoImpl rti = new RoomTypeDaoImpl();
        rti.createTable();
    }

    @Override
    public void createTable() {
       String sql = "create table IF NOT EXISTS RoomType(id int(5) auto_increment primary key, room_name varchar(20) unique)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println(" roomtype Table Created!");
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(RoomType rd) {
         String sql = "insert into RoomType(room_name) values(?)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, rd.getName());
            pstm.executeUpdate();
            System.out.println("Insert success!");
        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(RoomType rd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoomType getRoomTypeById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDetails getRoomTypeByRoomTypeCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RoomType> getList() {
         List<RoomType> list = new ArrayList<>();
        String sql = "select * from RoomType";
        try {

            PreparedStatement ps = CustomDBConnection.getDBConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RoomType pc = new RoomType(rs.getInt(1), rs.getString(2));
                list.add(pc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomTypeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    }
    

