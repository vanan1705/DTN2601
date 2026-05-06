package backend;

import entity.*;
import enums.GioiTinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise5 {
    //Question 2:
    //Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên.
    //Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ, khác), địa chỉ.
    //Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
    //Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
    //Các nhân viên có thuộc tính riêng: công việc.
    //Hãy xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp CanBo.
    //Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực hiện các chức năng
    //sau:
    //a) Thêm mới cán bộ.
    //b) Tìm kiếm theo họ tên.
    //c) Hiện thị thông tin về danh sách các cán bộ.
    //d) Nhập vào tên của cán bộ và delete cán bộ đó
    //e) Thoát khỏi chương trình.

    public static void  question2(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            List<CanBo> qlcb = new ArrayList<>();
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng: ");
            System.out.println("1. Thêm mới cán bộ.");
            System.out.println("2. Tìm kiếm theo họ tên.");
            System.out.println("3. Hiện thị thông tin về danh sách các cán bộ.");
            System.out.println("4. Nhập vào tên của cán bộ và delete cán bộ đó.");
            System.out.println("5. Thoát khỏi chương trình.");
            String chose = sc.nextLine();
            switch (chose){
                case "1":
                    System.out.print("Nhap ho ten: ");
                    String hoTen = sc.nextLine();

                    System.out.print("Nhap tuoi: ");
                    int tuoi = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nhap gioi tinh: ");
                    System.out.print("1. Nam ");
                    System.out.print("2. Nu ");
                    System.out.print("con lai. Khac");
                    String loaiGioiTinh = sc.nextLine();
                    GioiTinh gioiTinh = GioiTinh.KHAC;
                    switch (loaiGioiTinh){
                        case "1":
                            gioiTinh = GioiTinh.NAM;
                            break;
                        case "2":
                            gioiTinh = GioiTinh.NU;
                            break;
                    }

                    System.out.print("Nhap dia chi: ");
                    String diaChi = sc.nextLine();

                    System.out.println("Chon loai can bo:");
                    System.out.println("1. Cong nhan");
                    System.out.println("2. Ky su");
                    System.out.println("con lai => Nhan vien");

                    String loaiCanBo = sc.nextLine();

                    switch (loaiCanBo) {
                        case "1":
                            System.out.print("Nhap bac: ");
                            int bac = sc.nextInt();

                            CongNhan cn = new CongNhan(
                                    hoTen,
                                    tuoi,
                                    gioiTinh,
                                    diaChi,
                                    bac
                            );

                            qlcb.add(cn);
                            break;

                        case "2":
                            System.out.print("Nhap nganh dao tao: ");
                            String nganh = sc.nextLine();

                            KySu ks = new KySu(
                                    hoTen,
                                    tuoi,
                                    gioiTinh,
                                    diaChi,
                                    nganh
                            );

                            qlcb.add(ks);
                            break;

                        default:
                            System.out.print("Nhap cong viec: ");
                            String congViec = sc.nextLine();

                            NhanVien nv = new NhanVien(
                                    hoTen,
                                    tuoi,
                                    gioiTinh,
                                    diaChi,
                                    congViec
                            );

                            qlcb.add(nv);
                            break;
                        }

                    break;
                case "2":
                    System.out.print("Nhap ten can bo can tim: ");
                    String tenTim = sc.nextLine();
                    boolean timThay = false;
                    for (CanBo cb : qlcb) {
                        if (cb.getHoTen().equalsIgnoreCase(tenTim)) {
                            System.out.println(cb.toString());
                            timThay = true;
                        }
                    }
                    if (!timThay) {
                        System.out.println("Khong tim thay can bo!");
                    }

                    break;
                case "3":
                    for (CanBo cb : qlcb) {
                        System.out.println(cb.toString());
                    }
                case "4":
                    System.out.print("Nhap ten can bo can xoa: ");
                    String tenXoa = sc.nextLine();
                    for (CanBo cb : qlcb) {
                        if (cb.getHoTen().equalsIgnoreCase(tenXoa)) {
                            qlcb.remove(cb);
                            System.out.println("Da xoa can bo: "+ tenXoa);
                        }
                    }

                default:
                    return;
            }

        }
    }


    //Question 4 :
    //Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi tài liệu gồm có
    //các thuộc tính sau: Mã tài liệu(Mã tài liệu là duy nhất), Tên nhà xuất bản, số bản phát
    //hành.
    //Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
    //Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành.
    //Các báo cần quản lý thêm: Ngày phát hành.
    //Xây dựng chương trình để quản lý tài liệu (QLTV) cho thư viện một cách hiệu quả. Xây
    //dựng lớp QuanLySach có các chức năng sau:
    //a) Thêm mới tài liêu: Sách, tạp chí, báo.
    //b) Xoá tài liệu theo mã tài liệu.
    //c) Hiện thị thông tin về tài liệu.
    //d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
    //e) Thoát khỏi chương trình.
    public static void  question4(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            QuanLySach qls = new QuanLySach();
            System.out.println("Mời bạn nhập vào chức năng muốn sử dụng: ");
            System.out.println("1. Them tai lieu");
            System.out.println("2. Xoa tai lieu");
            System.out.println("3. Hien thi tai lieu");
            System.out.println("4. Tim theo loai");
            System.out.println("5. Thoat");
            String chose = sc.nextLine();
            switch (chose){
                case "1":
                    System.out.print("Nhap ma tai lieu: ");
                    String ma = sc.nextLine();

                    System.out.print("Nhap ten nha xuat ban: ");
                    String nxb = sc.nextLine();

                    System.out.print("Nhap so ban phat hanh: ");
                    int soBan = sc.nextInt();
                    sc.nextLine();

                    System.out.println("1. Sach");
                    System.out.println("2. Tap chi");
                    System.out.println("3. Bao");
                    String loaiTailieu = sc.nextLine();
                    switch (loaiTailieu){
                        case "1":
                            System.out.print("Nhap ten tac gia: ");
                            String tacGia = sc.nextLine();
                            System.out.print("Nhap so trang: ");
                            int soTrang = sc.nextInt();
                            Sach sach = new Sach(
                                    ma,
                                    nxb,
                                    soBan,
                                    tacGia,
                                    soTrang
                            );
                            qls.themTaiLieu(sach);
                            break;
                        case "2":
                            System.out.print("Nhap so phat hanh: ");
                            int soPhatHanh = sc.nextInt();

                            System.out.print("Nhap thang phat hanh: ");
                            int thang = sc.nextInt();

                            TapChi tapChi = new TapChi(
                                    ma,
                                    nxb,
                                    soBan,
                                    soPhatHanh,
                                    thang
                            );
                            qls.themTaiLieu(tapChi);
                            break;
                        case "3":
                            System.out.print("Nhap ngay phat hanh: ");
                            String ngay = sc.nextLine();
                            Bao bao = new Bao(
                                    ma,
                                    nxb,
                                    soBan,
                                    ngay
                            );
                            qls.themTaiLieu(bao);
                            break;

                        }
                case "2":
                    System.out.print("Nhap ma tai lieu can xoa: ");
                    String maXoa = sc.nextLine();
                    qls.xoaTaiLieu(maXoa);
                    break;

                case "3":
                    qls.hienThiTaiLieu();
                    break;

                case "4":
                    System.out.print("Nhap loai can tim: ");
                    System.out.print("sach");
                    System.out.print("tapchi");
                    System.out.print("bao");
                    String loai = sc.nextLine();

                    qls.timTheoLoai(loai);

                    break;
                default:
                    return;
            }

        }
    }

}
