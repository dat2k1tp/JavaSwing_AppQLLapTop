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
public class Lich_su1 {
    protected String ma_sp,ten_sp;
    protected int so_luong;

    public Lich_su1() {
    }

    public Lich_su1(String ma_sp, String ten_sp, int so_luong) {
        this.ma_sp = ma_sp;
        this.ten_sp = ten_sp;
        this.so_luong = so_luong;
    }

    public String getMa_sp() {
        return ma_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public int getSo_luong() {
        return so_luong;
    }
    
}
