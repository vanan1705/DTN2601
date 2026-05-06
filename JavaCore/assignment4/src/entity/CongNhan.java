package entity;

import enums.GioiTinh;

public class CongNhan extends CanBo{
    private Integer bac;

    public Integer getBac() {
        return bac;
    }

    public void setBac(Integer bac) {
        this.bac = bac;
    }

    public CongNhan(String hoTen, int tuoi, GioiTinh gioiTinh, String diaChi, Integer bac) {
        super( hoTen, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }

    @Override
    public String toString() {
        return "Cong nhan -> " + super.toString() +
                ", Bac: " + bac;
    }
}
