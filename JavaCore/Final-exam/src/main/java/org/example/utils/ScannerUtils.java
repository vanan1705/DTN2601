package org.example.utils;

import org.example.Common.StringCommon;


import java.sql.Date;
import java.util.Objects;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner sc = new Scanner(System.in);

    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Nhập lại:");
            }
        }
    }

    public static int inputID() {
        while (true) {
            int number = ScannerUtils.inputInt();
            if (number > 0) {
                return number;
            } else {
                System.err.println("ID phải lớn hơn 0! Nhập lại:");
            }
        }
    }

    public static String inputString() {
        while (true) {
            String string = sc.nextLine();
            if (Objects.nonNull(string) && !string.trim().isEmpty()) {
                return string;
            } else {
                System.err.println("Nhập lại:");
            }
        }
    }
    public static Date inputDate() {
        while (true) {
            try {
                String input = inputString();
                return Date.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.print("Sai định dạng hoặc ngày không tồn tại (Chuẩn: YYYY-MM-DD). Mời nhập lại: ");
            }
        }
    }



    public static String inputEmail() {
        while (true) {
            String email = sc.nextLine();
            if (email == null || email.trim().isEmpty() || !email.matches(StringCommon.EMAIL_REGEX)) {
                System.out.print("Nhập lại email: ");
            } else {
                return email;
            }
        }
    }


}
