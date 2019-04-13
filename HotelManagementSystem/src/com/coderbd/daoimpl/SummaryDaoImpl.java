/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd.daoimpl;

import com.coderbd.connection.CustomDBConnection;
import com.coderbd.dao.SummaryDao;
import com.coderbd.pojo.Summary;
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
public class SummaryDaoImpl implements SummaryDao {

    Connection conn = CustomDBConnection.getDBConnection();

    @Override
    public void createTable() {
        String sql = "create table if not exists summary(id int(20) auto_increment primary key,customer_name varchar(30),total_amount double,paid_amount double,due_amount double,add_date date)";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.execute();
            System.out.println("summary table is created successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void save(Summary s) {

        String sql = "insert into summary(customer_name ,total_amount,paid_amount ,due_amount,add_date) values(?,?,?,?,?)";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, s.getCustomer_name());
            pstm.setDouble(2, s.getTotal_amount());
            pstm.setDouble(3, s.getPaid_amount());
            pstm.setDouble(4, s.getDue_amount());
            pstm.setDate(5, s.getAdd_date());
            pstm.executeUpdate();
            System.out.println("summary table is updated successfully!");
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Summary s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Summary getSummaryByRoomCode(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Summary> getList() {
        List<Summary> list = new ArrayList<Summary>();
        String sql = "select * from summary";
        PreparedStatement pstm;
        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            Summary sum = new Summary(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDate(6));
            list.add(sum);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SummaryDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
