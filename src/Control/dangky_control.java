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
            // đối tượng PreparedStatement cung cấp một tính năng để thực thi một truy vấn được tham số hóa.
            // Một lợi thế quan trọng PreparedStatements ngăn chặn cuộc tấn công  SQL injection .
            stmt = con.prepareStatement(sql);
            //đặt tham số chỉ định 
            stmt.setString(1, dksv.getMssv());
            stmt.setString(2, dksv.getUser());
            stmt.setString(3, dksv.getPass());
            stmt.setString(4, dksv.getName());
            stmt.setString(5, dksv.getDate());
            stmt.setString(6, dksv.getClasssv());
            //thực thi câu lệnh
            stmt.executeUpdate();
            //hiên bảng thông báo 
            JOptionPane.showMessageDialog(null, "Đăng Ký Thành Công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Đăng Ký Thất Bại");
        }
    }
}
