import java.util.Arrays;
import java.util.Scanner;

public class StudentScoreStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[] scores = new float[100]; // Mảng lưu điểm
        int count = 0; // Số lượng sinh viên
        int choice;

        do {
            System.out.println("\n======== THỐNG KÊ ĐIỂM SINH VIÊN ========");
            System.out.println("1. Nhập danh sách điểm");
            System.out.println("2. Hiển thị danh sách điểm");
            System.out.println("3. Đếm số sinh viên theo loại");
            System.out.println("4. Tìm và in danh sách sinh viên đạt điểm cao nhất");
            System.out.println("5. Sắp xếp điểm tăng dần");
            System.out.println("6. Thoát");
            System.out.println("=========================================");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sinh viên: ");
                    count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        do {
                            System.out.print("Nhập điểm sinh viên thứ " + (i + 1) + " (0-10): ");
                            scores[i] = scanner.nextFloat();
                            if (scores[i] < 0 || scores[i] > 10) {
                                System.out.println(" Điểm không hợp lệ! Vui lòng nhập từ 0 đến 10.");
                            }
                        } while (scores[i] < 0 || scores[i] > 10);
                    }
                    System.out.println(" Đã nhập xong danh sách điểm.");
                    break;

                case 2:
                    System.out.println(" Danh sách điểm sinh viên:");
                    if (count == 0) {
                        System.out.println(" Chưa có dữ liệu. Hãy nhập danh sách điểm trước.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println("Sinh viên " + (i + 1) + ": " + scores[i]);
                        }
                    }
                    break;

                case 3:
                    countByCategory(scores, count);
                    break;

                case 4:
                    findMaxScoreStudents(scores, count);
                    break;

                case 5:
                    Arrays.sort(scores, 0, count);
                    System.out.println(" Đã sắp xếp điểm theo thứ tự tăng dần.");
                    break;

                case 6:
                    System.out.println(" Thoát chương trình.");
                    break;

                default:
                    System.out.println(" Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 6);
    }

    //  Đếm số sinh viên theo loại điểm
    public static void countByCategory(float[] scores, int count) {
        int weak = 0, average = 0, good = 0, veryGood = 0, excellent = 0;

        for (int i = 0; i < count; i++) {
            if (scores[i] < 5) {
                weak++;
            } else if (scores[i] < 6.5) {
                average++;
            } else if (scores[i] < 8) {
                good++;
            } else if (scores[i] < 9) {
                veryGood++;
            } else {
                excellent++;
            }
        }

        System.out.println(" Thống kê loại điểm:");
        System.out.println(" Yếu: " + weak + " sinh viên");
        System.out.println(" Trung bình: " + average + " sinh viên");
        System.out.println(" Khá: " + good + " sinh viên");
        System.out.println(" Giỏi: " + veryGood + " sinh viên");
        System.out.println(" Xuất sắc: " + excellent + " sinh viên");
    }

    //  Tìm sinh viên đạt điểm cao nhất
    public static void findMaxScoreStudents(float[] scores, int count) {
        if (count == 0) {
            System.out.println(" Chưa có dữ liệu.");
            return;
        }

        float maxScore = scores[0];
        for (int i = 1; i < count; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        System.out.println(" Điểm cao nhất: " + maxScore);
        System.out.println(" Danh sách sinh viên đạt điểm cao nhất:");
        for (int i = 0; i < count; i++) {
            if (scores[i] == maxScore) {
                System.out.println("- Sinh viên " + (i + 1) + ": " + scores[i]);
            }
        }
    }
}