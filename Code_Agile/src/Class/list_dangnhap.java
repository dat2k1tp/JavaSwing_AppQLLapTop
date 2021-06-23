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
public class list_dangnhap {
    protected String tenNV,maNV,username,passwords;

    public list_dangnhap() {
    }

    public list_dangnhap(String tenNV, String maNV, String username, String passwords) {
        this.tenNV = tenNV;
        this.maNV = maNV;
        this.username = username;
        this.passwords = passwords;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMaNV() {
        return maNV;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }
    
}
