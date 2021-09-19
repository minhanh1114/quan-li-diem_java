/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Connectsql.connectionft;
import Model.cpasv;
import Model.diemsv;
import Model.ttsv;
import View.qldiem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author TuanNguyen
 */
public class qldiem_control {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    //phương thức thêm điểm
    public void themdiem(diemsv dsv) {
        con = connectionft.getConnection();
        String sql = "insert into bangdiem(mssv,kyhoc,hocphan,tinchi,heso,giuaky,cuoiky,diemchu) values(?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, dsv.getMssv());
            stmt.setString(2, dsv.getKyhoc());
            stmt.setString(3, dsv.getHocphan());
            stmt.setFloat(4, dsv.getTinchi());
            stmt.setString(5, dsv.getHeso());
            stmt.setFloat(6, dsv.getGiuaky());
            stmt.setFloat(7, dsv.getCuoiky());
            stmt.setString(8, dsv.getDiemchu());
            //
            stmt.executeUpdate();
            //
            JOptionPane.showMessageDialog(null, "Thêm Thành Công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
        }
    }

    //phương thức sửa điểm
    public void suadiem(diemsv suadsv) {
        con = connectionft.getConnection();
        String sql = "update bangdiem set kyhoc=?, hocphan=?, tinchi=?, heso=?, giuaky=?, cuoiky=?, diemchu=? where hocphan=? and kyhoc=?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, suadsv.getKyhoc());
            stmt.setString(2, suadsv.getHocphan());
            stmt.setFloat(3, suadsv.getTinchi());
            stmt.setString(4, suadsv.getHeso());
            stmt.setFloat(5, suadsv.getGiuaky());
            stmt.setFloat(6, suadsv.getCuoiky());
            stmt.setString(7, suadsv.getDiemchu());
            stmt.setString(8, suadsv.getHocphan());
            stmt.setString(9, suadsv.getKyhoc());
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa Thành Công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sửa Thất Bại");
        }
    }

    //phương thúc xóa điểm
    public void xoadiem(diemsv xoadsv) {
        con = connectionft.getConnection();
        String sql = "delete from bangdiem where hocphan=? and kyhoc=?";
        try {
            stmt = con.prepareStatement(sql);
            //
            stmt.setString(1, xoadsv.getHocphan());
            stmt.setString(2, xoadsv.getKyhoc());
            //
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa Thành Công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Xóa Thất Bại");
        }
    }

    //phương thức tính điểm CPA từng kỳ
    public void cpa(cpasv dcpa) {
        float diemcpa = 0;
        float tinchi = 0;
        //
        con = connectionft.getConnection();
        //
        String sql = "select kyhoc, tinchi, diemchu from bangdiem where kyhoc='" + dcpa.getKyhoc() + "'";
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            //
            while (rs.next()) {
                switch (rs.getString(3)) {
                    case "F":
                        diemcpa += 0f * rs.getFloat(2);
                        tinchi += rs.getFloat(2);
                        break;
                    case "D":
                        diemcpa += 1f * rs.getFloat(2);
                        tinchi += rs.getFloat(2);
                        break;
                    case "D+":
                        diemcpa += 1.5f * rs.getFloat(2);
                        tinchi += rs.getFloat(2);
                        break;
                    case "C":
                        diemcpa += 2f * rs.getFloat(2);
                        tinchi += rs.getFloat(2);
                        break;
                    case "C+":
                        diemcpa += 2.5f * rs.getFloat(2);
                        tinchi += rs.getFloat(2);
                        break;
                    case "B":
                        diemcpa += 3f * rs.getFloat(2);
                        tinchi += rs.getFloat(2);
                        break;
                    case "B+":
                        diemcpa += 3.5f * rs.getFloat(2);
                        tinchi += rs.getFloat(2);
                        break;
                    case "A":
                        diemcpa += 4f * rs.getFloat(2);
                        tinchi += rs.getFloat(2);
                        break;
                    case "A+":
                        diemcpa += 4f * rs.getFloat(2);
                        tinchi += rs.getFloat(2);
                        break;
                }
            }
            //
            int a = (int) ((diemcpa / tinchi) * 100);
            dcpa.setCpa((float) a/100f);
            //
        } catch (Exception e) {
        }
    }

    //phương thức GPA
    public void gpa(cpasv dgpa) {
        float diemgpa = 0;
        float tinchi = 0;
        //
        con = connectionft.getConnection();
        //
        String sql = "select tinchi, diemchu from bangdiem";
        //
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            //
            while (rs.next()) {
                switch (rs.getString(2)) {
                    case "F":
                        diemgpa += 0f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "D":
                        diemgpa += 1f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "D+":
                        diemgpa += 1.5f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "C":
                        diemgpa += 2f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "C+":
                        diemgpa += 2.5f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "B":
                        diemgpa += 3f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "B+":
                        diemgpa += 3.5f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "A":
                        diemgpa += 4f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "A+":
                        diemgpa += 4f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                }
            }
            //
            int a = (int) ((diemgpa / tinchi) * 100);
            dgpa.setGpa((float) a / 100f);
            //
        } catch (Exception e) {
        }
    }

    //phương thức tính cpa cần để có bằng tương ứng ra trường
    public void gpacan(cpasv a) {
        float tinchi = 0;
        float gpa;
        float diemgpa = 0;
        con = connectionft.getConnection();
        //
        String sql = "select tinchi, diemchu from bangdiem";
        //
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            //tính tổng tín chỉ đã qua
            while (rs.next()) {
                switch (rs.getString(2)) {
                    case "F":
                        diemgpa += 0f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "D":
                        diemgpa += 1f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "D+":
                        diemgpa += 1.5f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "C":
                        diemgpa += 2f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "C+":
                        diemgpa += 2.5f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "B":
                        diemgpa += 3f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "B+":
                        diemgpa += 3.5f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "A":
                        diemgpa += 4f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                    case "A+":
                        diemgpa += 4f * rs.getFloat(1);
                        tinchi += rs.getFloat(1);
                        break;
                }
            }
            //tính Gpa cần
            switch (a.getHlsv()) {
                case "Giỏi":
                    gpa = (3.2f * 158f - diemgpa) / (158f - tinchi);
                    int b = (int) (gpa * 100);
                    a.setGpacan((float) b / 100f);
                    break;
                case "Khá":
                    gpa = (2.5f * 158f - diemgpa) / (158f - tinchi);
                    b = (int) (gpa * 100);
                    a.setGpacan((float) b / 100f);
                    break;
                case "Trung Bình":
                    gpa = (2f * 158 - diemgpa) / (158f - tinchi);
                    b = (int) (gpa * 100);
                    a.setGpacan((float) b / 100f);
            }
            //
        } catch (Exception e) {
        }
    }
}
