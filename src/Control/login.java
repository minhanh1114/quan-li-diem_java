/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connectsql.connectionft;
import Model.ttsv;
import View.login_view;
import View.qldiem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author TuanNguyen
 */
public class login {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    // hàm này được truyền bới biếm sv từ class ttsv
    public void check_login(ttsv sv) {
        //
        con = connectionft.getConnection();
        String sql = "select * from ttsv where username=? and pass=?";
        try {
            // đối tượng PreparedStatement cung cấp một tính năng để thực thi một truy vấn được tham số hóa.
            // Một lợi thế quan trọng PreparedStatements ngăn chặn cuộc tấn công  SQL injection .
            
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, sv.getUser());
            stmt.setString(2, sv.getPass());
            //
            rs = stmt.executeQuery();
            // NẾU CSDL CÓ DỮ LIỆU GÁN dữ liệu CHO CLASS TTSV
            if (rs.next()) {
                // khai báo 1 biến getsv kiểu ttsv new ttsv() cấp vùng nhớ
                ttsv getsv = new ttsv();
                //lấy thông tin sinh viên gán vào class ttsv
                getsv.setMssv(rs.getString("mssv"));
                getsv.setName(rs.getString("name"));
                getsv.setDate(rs.getString("date"));
                getsv.setClasssv(rs.getString("class"));
                //hiển thị thông báo đăng nhập 
                sv.setTbdn("Đăng Nhập Thành Công");
                // khai báo biến lg class qldiem với tham số getsv
                qldiem lg = new qldiem(getsv);
                lg.setVisible(true); // hiện thị form quản lí điểm
            }
            else {
                sv.setTbdn("Đăng Nhập Thất Bại");
            }
        } catch (Exception e) {
        }
    }
}
