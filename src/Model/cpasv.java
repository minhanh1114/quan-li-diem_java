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
public class cpasv {

    private String kyhoc;
    private Float tinchi;
    private String diemchu;
    private Float cpa;
    private Float gpa;
    private Float gpacan;
    private String hlsv;

    public cpasv() {
    }

    public cpasv(String kyhoc, Float tinchi, String diemchu, Float cpa, Float gpa, Float gpacan, String hlsv) {
        this.kyhoc = kyhoc;
        this.tinchi = tinchi;
        this.diemchu = diemchu;
        this.cpa = cpa;
        this.gpa = gpa;
        this.gpacan = gpacan;
        this.hlsv = hlsv;
    }

    public String getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(String kyhoc) {
        this.kyhoc = kyhoc;
    }

    public Float getTinchi() {
        return tinchi;
    }

    public void setTinchi(Float tinchi) {
        this.tinchi = tinchi;
    }

    public String getDiemchu() {
        return diemchu;
    }

    public void setDiemchu(String diemchu) {
        this.diemchu = diemchu;
    }

    public Float getCpa() {
        return cpa;
    }

    public void setCpa(Float cpa) {
        this.cpa = cpa;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public Float getGpacan() {
        return gpacan;
    }

    public void setGpacan(Float gpacan) {
        this.gpacan = gpacan;
    }

    public String getHlsv() {
        return hlsv;
    }

    public void setHlsv(String hlsv) {
        this.hlsv = hlsv;
    }

    
}
