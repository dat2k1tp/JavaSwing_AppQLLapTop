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
public class TC_hoadonchitiet {

    protected String MaHoaDonChiTiet, maHD;
    protected float SoLuong;
    protected String maSP;
    protected float GiaSP, GiamGia;

    public TC_hoadonchitiet() {
    }

    public TC_hoadonchitiet(String MaHoaDonChiTiet, String maHD, float SoLuong, String maSP, float GiaSP, float GiamGia) {
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
        this.maHD = maHD;
        this.SoLuong = SoLuong;
        this.maSP = maSP;
        this.GiaSP = GiaSP;
        this.GiamGia = GiamGia;
    }

    public String getMaHoaDonChiTiet() {
        return MaHoaDonChiTiet;
    }

    public void setMaHoaDonChiTiet(String MaHoaDonChiTiet) {
        this.MaHoaDonChiTiet = MaHoaDonChiTiet;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public float getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(float SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public float getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(float GiaSP) {
        this.GiaSP = GiaSP;
    }

    public float getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(float GiamGia) {
        this.GiamGia = GiamGia;
    }
    
}
