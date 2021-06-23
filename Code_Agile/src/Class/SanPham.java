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
public class SanPham {
    protected String maSp,tenSP;
    protected float gia;
    protected int namSX,soLuong;
    protected String moTa;

    public SanPham() {
    }

    public SanPham(String maSp, String tenSP, float gia, int namSX, int soLuong, String moTa) {
        this.maSp = maSp;
        this.tenSP = tenSP;
        this.gia = gia;
        this.namSX = namSX;
        this.soLuong = soLuong;
        this.moTa = moTa;
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

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    
}
