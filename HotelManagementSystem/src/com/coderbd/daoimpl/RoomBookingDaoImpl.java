/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.daoimpl;

import com.coderbd.connection.CustomDBConnection;
import com.coderbd.dao.RoomBookingDao;
import com.coderbd.pojo.RoomBooking;
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
public class RoomBookingDaoImpl implements RoomBookingDao {

    Connection conn = CustomDBConnection.getDBConnection();

    @Override
    public void createTable() {
        String sql = "create table IF NOT EXISTS bookroom(id int(11) auto_increment primary key, customer_name varchar(20), booking_date date,Checkin_date date, checkout_date date,numberOf_days int(20), perday_amout Double,total_rent double,due_amont double)";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println(" Bokking Table Created!!");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void save(RoomBooking rbd) {
        String sql = "insert into bookroom(customer_name, booking_date,Checkin_date , checkout_date,numberOf_days, perday_amout,total_rent,due_amont) values(?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, rbd.getCustomer_name());
            pstm.setDate(2, rbd.getBookingDate());

            pstm.setDate(3, rbd.getCheckInDate());
            pstm.setDate(4, rbd.getCheckOutDate());
            pstm.setInt(5, rbd.getNumberOfDays());
            pstm.setDouble(6, rbd.getPerDayAmount());
            pstm.setDouble(7, rbd.getTotaRentAmount());
            pstm.setDouble(8, rbd.getDueAmount());

            pstm.executeUpdate();
            System.out.println("Insert success!");
        } catch (SQLException ex) {
            Logger.getLogger(RoomBooking.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(RoomBooking rbd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoomBooking getRoomBookingById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoomBooking getRoomBookingByRoomBookingCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RoomBooking> getList() {
        /*
        RoomBooking(int customerId, Room room, Date bookingDate,
        Date checkInDate, Date checkOutDate, int numberOfDays, double perDayAmount, double totaRentAmount, double bookingAmount, double dueAmount) {
       
         */
        List<RoomBooking> list = new ArrayList();
        /*
         RoomBooking(int customerId, Date bookingDate,
         Date checkInDate, Date checkOutDate, int numberOfDays,
         double perDayAmount,
         double totaRentAmount,  double dueAmount)
         */
        String sql = "select * from bookroom";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RoomBooking p = new RoomBooking(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getDouble(7), rs.getDouble(7));
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDetailsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
