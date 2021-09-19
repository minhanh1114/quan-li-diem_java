/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectsql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TuanNguyen
 */
public class connectionft {
    private static Connection con;
    public static Connection getConnection() {
        try {            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con  = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;user=sa;password=123;database=quanlydiem");
        } catch (Exception e) {
                System.out.println("Connect Error");
        }
        return con;
    }
}
