/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Admin
 */
public class HoaDon {
    protected String MaSP,TenSP;
    protected float giaSP,giamGia;
    protected int soLuong;
    

    public HoaDon() {
    }

    public HoaDon(String MaSP, String TenSP, float giaSP, float giamGia, int soLuong) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.giaSP = giaSP;
        this.giamGia = giamGia;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return MaSP;
    }

  

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public float getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(float giaSP) {
        this.giaSP = giaSP;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    public float thanhTien(){
        
        return this.getGiaSP()*this.getSoLuong()-this.getGiaSP()*this.getSoLuong()*getGiamGia()/100;
    }
}
