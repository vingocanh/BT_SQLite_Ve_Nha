package com.example.btsqlitevenha;

public class DuLieuSinhVien {

    private int id;
    private String hoTen;
    private String ngaySinh;
    private String tenTruong;
    private String queQuan;
    private String SDT;
    private String Email;
    private int gioiTinh;

    public DuLieuSinhVien() {
    }

    public DuLieuSinhVien(String hoTen, String ngaySinh, String tenTruong, String queQuan, String SDT, String email, int gioiTinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.tenTruong = tenTruong;
        this.queQuan = queQuan;
        this.SDT = SDT;
        Email = email;
        this.gioiTinh = gioiTinh;
    }

    public DuLieuSinhVien(int id, String hoTen, String ngaySinh, String tenTruong, String queQuan, String SDT, String email, int gioiTinh) {
        this.id = id;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.tenTruong = tenTruong;
        this.queQuan = queQuan;
        this.SDT = SDT;
        Email = email;
        this.gioiTinh = gioiTinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
