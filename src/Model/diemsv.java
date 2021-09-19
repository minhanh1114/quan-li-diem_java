/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author TuanNg
 */
public class diemsv {
    private int id;
    private String mssv;
    private String kyhoc;
    private String hocphan;
    private float tinchi;
    private String heso;
    private float giuaky;
    private float cuoiky;
    private String diemchu;

    public diemsv() {
    }

    public diemsv(int id, String mssv, String kyhoc, String hocphan, float tinchi, String heso, float giuaky, float cuoiky, String diemchu) {
        this.id = id;
        this.mssv = mssv;
        this.kyhoc = kyhoc;
        this.hocphan = hocphan;
        this.tinchi = tinchi;
        this.heso = heso;
        this.giuaky = giuaky;
        this.cuoiky = cuoiky;
        this.diemchu = diemchu;
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

    public String getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(String kyhoc) {
        this.kyhoc = kyhoc;
    }

    public String getHocphan() {
        return hocphan;
    }

    public void setHocphan(String hocphan) {
        this.hocphan = hocphan;
    }

    public float getTinchi() {
        return tinchi;
    }

    public void setTinchi(float tinchi) {
        this.tinchi = tinchi;
    }

    public String getHeso() {
        return heso;
    }

    public void setHeso(String heso) {
        this.heso = heso;
    }

    public float getGiuaky() {
        return giuaky;
    }

    public void setGiuaky(float giuaky) {
        this.giuaky = giuaky;
    }

    public float getCuoiky() {
        return cuoiky;
    }

    public void setCuoiky(float cuoiky) {
        this.cuoiky = cuoiky;
    }

    public String getDiemchu() {
        return diemchu;
    }

    public void setDiemchu(String diemchu) {
        this.diemchu = diemchu;
    }

    

}
