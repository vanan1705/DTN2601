package entity;

import java.util.ArrayList;
import java.util.List;

public class QuanLySach {
    private List<TaiLieu> danhSachTaiLieu;
    public QuanLySach() {
        danhSachTaiLieu = new ArrayList<>();
    }
    // a) Them tai lieu
    public void themTaiLieu(TaiLieu taiLieu) {
        danhSachTaiLieu.add(taiLieu);
    }

    // b) Xoa theo ma tai lieu
    public void xoaTaiLieu(String maTaiLieu ) {

        for (TaiLieu tl: danhSachTaiLieu){
            if (tl.getMaTaiLieu().equalsIgnoreCase(maTaiLieu)) {
                danhSachTaiLieu.remove(tl);
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
    }

    // c) Hien thi danh sach
    public void hienThiTaiLieu() {

        for (TaiLieu tl : danhSachTaiLieu) {
            System.out.println(tl.toString());
        }
    }

    // d) Tim theo loai
    public void timTheoLoai(String loai) {

        boolean timThay = false;

        for (TaiLieu tl : danhSachTaiLieu) {

            if (loai.equalsIgnoreCase("sach")
                    && tl instanceof Sach) {

                System.out.println(tl);
                timThay = true;
            }

            else if (loai.equalsIgnoreCase("tapchi")
                    && tl instanceof TapChi) {

                System.out.println(tl);
                timThay = true;
            }

            else if (loai.equalsIgnoreCase("bao")
                    && tl instanceof Bao) {

                System.out.println(tl);
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay!");
        }
    }
}
