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
public class Lich_su {

    protected String ma_hd, ma_sp, ma_nv, ma_kh, ten_sp;
    protected int so_luong;
    protected float gia, giam_gia;
    protected String ngay_ban, ghi_chu;

    public Lich_su() {
    }

    public Lich_su(String ma_hd, String ma_sp, String ma_nv, String ma_kh, String ten_sp, int so_luong, float gia, float giam_gia, String ngay_ban, String ghi_chu) {
        this.ma_hd = ma_hd;
        this.ma_sp = ma_sp;
        this.ma_nv = ma_nv;
        this.ma_kh = ma_kh;
        this.ten_sp = ten_sp;
        this.so_luong = so_luong;
        this.gia = gia;
        this.giam_gia = giam_gia;
        this.ngay_ban = ngay_ban;
        this.ghi_chu = ghi_chu;
    }
    public float thanh_tien(int so_luong, float gia, float giam_gia) {
        return (so_luong * gia) - (gia * (giam_gia / 100) * so_luong);
    }

    public String getMa_hd() {
        return ma_hd;
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public String getMa_nv() {
        return ma_nv;
    }

    public String getMa_kh() {
        return ma_kh;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public float getGia() {
        return gia;
    }

    public float getGiam_gia() {
        return giam_gia;
    }

    public String getNgay_ban() {
        return ngay_ban;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

}
