/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Hello Kiên
 */
public class TC_new {
    protected String maSp ,tenSP;
    protected float gia;
    protected int so_luong;

    public TC_new() {
    }

    public TC_new(String maSp, String tenSP, float gia, int so_luong) {
        this.maSp = maSp;
        this.tenSP = tenSP;
        this.gia = gia;
        this.so_luong = so_luong;
    }

    public String getMaSp() {
        return maSp;
    }


    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }
    
}
