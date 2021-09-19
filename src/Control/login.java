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

    public void check_login(ttsv sv) {
        con = connectionft.getConnection();
        String sql = "select * from ttsv where username=? and pass=?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, sv.getUser());
            stmt.setString(2, sv.getPass());
            //
            rs = stmt.executeQuery();
            // NẾU CSDL CÓ DỮ LIỆU GÁN dữ liệu CHO CLASS TTSV
            if (rs.next()) {
                ttsv getsv = new ttsv();
                getsv.setMssv(rs.getString("mssv"));
                getsv.setName(rs.getString("name"));
                getsv.setDate(rs.getString("date"));
                getsv.setClasssv(rs.getString("class"));
                //
                sv.setTbdn("Đăng Nhập Thành Công");
                qldiem lg = new qldiem(getsv);
                lg.setVisible(true);
            }
            else {
                sv.setTbdn("Đăng Nhập Thất Bại");
            }
        } catch (Exception e) {
        }
    }
}
