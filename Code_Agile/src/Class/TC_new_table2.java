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
public class TC_new_table2 {

    protected String maSP, tenSP;
    protected int soluong;
    protected float gia, giamgia, thanh_tien;

    public TC_new_table2() {
    }

    public TC_new_table2(String maSP, String tenSP, int soluong, float gia, float giamgia, float thanh_tien) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.gia = gia;
        this.giamgia = giamgia;
        this.thanh_tien = thanh_tien;

    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public float getGiamgia() {
        return giamgia;
    }

    public void setGiamgia(float giamgia) {
        this.giamgia = giamgia;
    }

    public float getThanh_tien() {
        return thanh_tien;
    }

    public void setThanh_tien(float thanh_tien) {
        this.thanh_tien = thanh_tien;
    }

}
