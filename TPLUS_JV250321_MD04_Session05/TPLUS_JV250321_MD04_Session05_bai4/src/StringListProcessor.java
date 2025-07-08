import java.util.Arrays;
import java.util.Scanner;

public class StringListProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringList = new String[100]; // Danh sách chuỗi
        int count = 0; // Số lượng chuỗi hiện có
        int choice;

        do {
            System.out.println("\n========= XỬ LÝ DANH SÁCH CHUỖI =========");
            System.out.println("1. Nhập danh sách chuỗi");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tìm và in ra chuỗi có độ dài lớn nhất");
            System.out.println("4. Đếm chuỗi có chứa ký tự số");
            System.out.println("5. Tìm và in ra chuỗi Palindrome");
            System.out.println("6. Sắp xếp chuỗi theo độ dài tăng dần");
            System.out.println("7. Thoát");
            System.out.println("========================================");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ newline

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng chuỗi: ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ newline
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập chuỗi thứ " + (i + 1) + ": ");
                        stringList[count++] = scanner.nextLine();
                    }
                    System.out.println(" Đã nhập xong danh sách chuỗi.");
                    break;

                case 2:
                    System.out.println(" Danh sách chuỗi:");
                    if (count == 0) {
                        System.out.println(" Danh sách rỗng.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + ". " + stringList[i]);
                        }
                    }
                    break;

                case 3:
                    findLongestString(stringList, count);
                    break;

                case 4:
                    countStringsWithDigits(stringList, count);
                    break;

                case 5:
                    findPalindromeStrings(stringList, count);
                    break;

                case 6:
                    sortStringsByLength(stringList, count);
                    System.out.println(" Đã sắp xếp chuỗi theo độ dài tăng dần.");
                    break;

                case 7:
                    System.out.println(" Thoát chương trình.");
                    break;

                default:
                    System.out.println(" Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 7);
    }

    //  Tìm và in ra chuỗi có độ dài lớn nhất
    public static void findLongestString(String[] arr, int count) {
        if (count == 0) {
            System.out.println("️ Danh sách rỗng.");
            return;
        }
        String longest = arr[0];
        for (int i = 1; i < count; i++) {
            if (arr[i].length() > longest.length()) {
                longest = arr[i];
            }
        }
        System.out.println(" Chuỗi có độ dài lớn nhất: \"" + longest + "\" (Độ dài: " + longest.length() + ")");
    }

    //  Đếm chuỗi có chứa ký tự số
    public static void countStringsWithDigits(String[] arr, int count) {
        int digitCount = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i].matches(".*\\d.*")) {
                digitCount++;
            }
        }
        System.out.println(" Số chuỗi có chứa ký tự số: " + digitCount);
    }

    //  Tìm và in ra chuỗi Palindrome
    public static void findPalindromeStrings(String[] arr, int count) {
        boolean found = false;
        System.out.println(" Các chuỗi Palindrome:");
        for (int i = 0; i < count; i++) {
            String cleaned = arr[i].replaceAll("\\s+", "").toLowerCase();
            String reversed = new StringBuilder(cleaned).reverse().toString();
            if (cleaned.equals(reversed)) {
                System.out.println("- " + arr[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" Không có chuỗi Palindrome nào.");
        }
    }

    //  Sắp xếp chuỗi theo độ dài tăng dần
    public static void sortStringsByLength(String[] arr, int count) {
        Arrays.sort(arr, 0, count, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }
}