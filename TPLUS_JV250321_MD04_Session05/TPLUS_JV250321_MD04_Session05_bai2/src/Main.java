import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//========== QUẢN LÝ TÊN SINH VIÊN ==========
//
//        1. Thêm tên sinh viên
//
//        2. Hiển thị danh sách
//
//        3. Tìm tên sinh viên chứa từ khóa
//
//        4. Đếm số sinh viên có tên bắt đầu bằng chữ cái nhập vào
//
//        5. Sắp xếp danh sách tên theo thứ tự A-Z
//
//        6. Thoát
//
//                ==========================================
//
//                Chọn:
        Scanner sc = new Scanner(System.in);
        int number = 0;
        String[] ints = new String[100];
        do {
            System.out.println("1. Thêm tên sinh viên");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm tên sinh viên chứa từ khóa");
            System.out.println("4. Đếm số sinh viên có tên bắt đầu bằng chữ cái nhập vào");
            System.out.println("5. Sắp xếp danh sách tên theo thứ tự A-Z");
            System.out.println("6. Thoát");
            System.out.println("Chọn:");
            int choise = Integer.parseInt(sc.nextLine());

            switch (choise) {
                case 1:
                    number++;
                    String name;
                    System.out.println("Nhập tên sinh viên mới:");
                    name = sc.nextLine();
                    String sortname = name.trim().replaceAll("\\s+", "");
                    String [] parts = sortname.split(" ");
                    StringBuilder altername = new StringBuilder();
                    for (int i = 0; i < parts.length; i++) {
                        altername.append(Character.toUpperCase(ints[i].charAt(0)))
                                .append(ints[i].substring(1).toLowerCase())
                                .append(" ");
                    }
                    ints[number++] = altername.toString();
                    System.out.println(altername.toString().trim());
                    break;
                case 2:
                    System.out.println(Arrays.toString(ints));
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập lại!");
                    break;
            }
        } while (true);
    }
}