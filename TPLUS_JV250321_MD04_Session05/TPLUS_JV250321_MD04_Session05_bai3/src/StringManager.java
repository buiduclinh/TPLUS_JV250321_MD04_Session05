import java.util.Scanner;

public class StringManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = ""; // Chuỗi nhập từ người dùng
        int choice;

        do {
            System.out.println("\n*************** MENU ***************");
            System.out.println("1. Nhập chuỗi");
            System.out.println("2. Đếm số ký tự thường, hoa, số, đặc biệt");
            System.out.println("3. Đảo ngược chuỗi");
            System.out.println("4. Kiểm tra Palindrome (chuỗi đối xứng)");
            System.out.println("5. Chuẩn hóa chuỗi");
            System.out.println("6. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line

            switch (choice) {
                case 1:
                    System.out.print("Nhập chuỗi: ");
                    str = scanner.nextLine();
                    break;

                case 2:
                    countCharacters(str);
                    break;

                case 3:
                    reverseString(str);
                    break;

                case 4:
                    checkPalindrome(str);
                    break;

                case 5:
                    str = normalizeString(str);
                    System.out.println("Chuỗi sau khi chuẩn hóa: " + str);
                    break;

                case 6:
                    System.out.println(" Thoát chương trình.");
                    break;

                default:
                    System.out.println(" Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 6);
    }

    //  Đếm ký tự thường, hoa, số, đặc biệt
    public static void countCharacters(String str) {
        int lower = 0, upper = 0, digit = 0, special = 0;
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower++;
            } else if (Character.isUpperCase(c)) {
                upper++;
            } else if (Character.isDigit(c)) {
                digit++;
            } else {
                special++;
            }
        }
        System.out.println(" Ký tự thường: " + lower);
        System.out.println(" Ký tự hoa: " + upper);
        System.out.println(" Số: " + digit);
        System.out.println(" Ký tự đặc biệt: " + special);
    }

    // Đảo ngược chuỗi
    public static void reverseString(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println(" Chuỗi đảo ngược: " + reversed);
    }

    // Kiểm tra Palindrome
    public static void checkPalindrome(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        if (cleaned.equals(reversed)) {
            System.out.println(" Đây là chuỗi Palindrome (đối xứng).");
        } else {
            System.out.println(" Đây KHÔNG phải là chuỗi Palindrome.");
        }
    }

    //  Chuẩn hóa chuỗi
    public static String normalizeString(String str) {
        str = str.trim().replaceAll("\\s+", " "); // Xóa khoảng trắng dư thừa
        String[] words = str.split(" ");
        StringBuilder normalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                normalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return normalized.toString().trim();
    }
}