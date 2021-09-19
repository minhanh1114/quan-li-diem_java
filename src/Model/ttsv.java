/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author TuanNguyen
 */
public class ttsv {
    private int id;
    private String mssv;
    private String user;
    private String pass;
    private String name;
    private String date;
    private String classsv;
    private String tbdn;

    public ttsv() {
    }

    public ttsv(int id, String mssv, String user, String pass, String name, String date, String classsv, String tbdn) {
        this.id = id;
        this.mssv = mssv;
        this.user = user;
        this.pass = pass;
        this.name = name;
        this.date = date;
        this.classsv = classsv;
        this.tbdn = tbdn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClasssv() {
        return classsv;
    }

    public void setClasssv(String classsv) {
        this.classsv = classsv;
    }

    public String getTbdn() {
        return tbdn;
    }

    public void setTbdn(String tbdn) {
        this.tbdn = tbdn;
    }
    
    
    
    
}
