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
public class TC_add_hoadon {

    protected String maHD, maNV, maKH, NgayMuaHang, GhiChu;

    public TC_add_hoadon() {
    }

    public TC_add_hoadon(String maHD, String maNV, String maKH, String NgayMuaHang, String GhiChu) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.NgayMuaHang = NgayMuaHang;
        this.GhiChu = GhiChu;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getNgayMuaHang() {
        return NgayMuaHang;
    }

    public void setNgayMuaHang(String NgayMuaHang) {
        this.NgayMuaHang = NgayMuaHang;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
}
