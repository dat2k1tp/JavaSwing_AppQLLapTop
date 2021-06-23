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
public class Dang_ky {

    protected String ma_nv, username, password, ten_nv, so_dt, email, chuc_vu, gioi_tinh, dia_chi;

    public Dang_ky() {
    }

    public Dang_ky(String ma_nv, String username, String password, String ten_nv, String so_dt, String email, String chuc_vu, String gioi_tinh, String dia_chi) {
        this.ma_nv = ma_nv;
        this.username = username;
        this.password = password;
        this.ten_nv = ten_nv;
        this.so_dt = so_dt;
        this.email = email;
        this.chuc_vu = chuc_vu;
        this.gioi_tinh = gioi_tinh;
        this.dia_chi = dia_chi;
    }

    public String getMa_nv() {
        return ma_nv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTen_nv() {
        return ten_nv;
    }

    public void setTen_nv(String ten_nv) {
        this.ten_nv = ten_nv;
    }

    public String getSo_dt() {
        return so_dt;
    }

    public void setSo_dt(String so_dt) {
        this.so_dt = so_dt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChuc_vu() {
        return chuc_vu;
    }

    public void setChuc_vu(String chuc_vu) {
        this.chuc_vu = chuc_vu;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }
    
    

}
