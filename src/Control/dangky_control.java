/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connectsql.connectionft;
import Model.ttsv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author TuanNguyen
 */
public class dangky_control {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    public void dangky(ttsv dksv) {
        con = connectionft.getConnection();
        String sql = "insert into ttsv(mssv,username,pass,name,date,class) values(?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, dksv.getMssv());
            stmt.setString(2, dksv.getUser());
            stmt.setString(3, dksv.getPass());
            stmt.setString(4, dksv.getName());
            stmt.setString(5, dksv.getDate());
            stmt.setString(6, dksv.getClasssv());
            //
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Đăng Ký Thành Công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Đăng Ký Thất Bại");
        }
    }
}
