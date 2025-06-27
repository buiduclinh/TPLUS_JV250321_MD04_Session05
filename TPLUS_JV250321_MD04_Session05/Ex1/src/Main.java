import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ints = new int[100];
        int currentint = 0;
        do {
            System.out.println("*********************MENU********************");
            System.out.println("1. Nhập giá trị n phần tử của mảng (n nhập từ bàn phím) ");
            System.out.println("2. In giá trị các phần tử trong mảng ");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng ");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong  \n" +
                    "mảng (k nhập từ bàn phím) ");
            System.out.println("5. Sử dụng thuật toán sắp xếp hoán đổi sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng ");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, các phần \n" +
                    "tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, các phần tử còn lại ở giữa \n" +
                    "mảng theo thứ tự tăng dần ");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí ");
            System.out.println("9. Thoát  ");
            System.out.println("Lựa chọn của bạn: ");
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    System.out.println("Nhập độ dài của mảng: ");
                    int n = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập số vào mảng:");
                        ints[currentint] = Integer.parseInt(sc.nextLine());
                        currentint++;
                    }
                    System.out.println();
                    break;
                case 2:
                    for (int i = 0; i < currentint; i++) {
                        System.out.print(ints[i] + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    int totalNumberPositive = 0;
                    int countNummberPositive = 0;
//                    3. Tính trung bình các phần tử dương (>0) trong mảng
                    for (int i = 0; i < currentint; i++) {
                        if (ints[i] > 0) {
                            totalNumberPositive += ints[i];
                            countNummberPositive++;
                        }
                    }
                    System.out.println(totalNumberPositive / countNummberPositive);
                    System.out.println();
                    break;
                case 4:
//                    In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong
//                    mảng (k nhập từ bàn phím)
                    System.out.println("Nhập số bạn cần tìm trong mảng ");
                    int k = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < currentint; i++) {
                        if (k == ints[i]) {
                            System.out.printf("%5d", i);
                        }
                    }
                    System.out.println();
                    break;
                case 5:
//                    5. Sử dụng thuật toán sắp xếp hoán đổi sắp xếp mảng giảm dần
                    for (int i = 0; i < currentint; i++) {
                        for (int j = 0; j < currentint; j++) {
                            if (ints[i] > ints[j]) {
                                int temp = ints[i];
                                ints[i] = ints[j];
                                ints[j] = temp;
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 6:
//                    6. Tính số lượng các phần tử là số nguyên tố trong mảng
                    int isPrimeCount = 0;

                    for (int i = 0; i < currentint; i++) {
                        boolean isPrime = true;
                        if (ints[i] < 2) {
                            isPrime = false;
                        } else {
                            for (int j = 2; j <= Math.sqrt(ints[i]); j++) {
                                if (ints[i] % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                            if (isPrime) {
                                isPrimeCount++;
                            }
                        }
                    }
                    System.out.println(isPrimeCount);
                    System.out.println();
                    break;
                case 7:
//                    7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng
//                    theo thứ tự tăng dần, các phần
//                    tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần,
//                    các phần tử còn lại ở giữa
//                    mảng theo thứ tự tăng dần
                    int currenEven = 0;
                    int currenOdd = 0;
                    int currenOther = 0;
                    for (int i = 0; i < currentint; i++) {
                        if (ints[i] % 2 == 0 && ints[i] % 3 == 0) {
                            currenEven++;
                        } else if (ints[i] % 2 != 0 && ints[i] % 3 == 0) {
                            currenOdd++;
                        } else {
                            currenOther++;
                        }
                    }
                    int[] evenArray = new int[currenEven];
                    int[] oddArray = new int[currenOdd];
                    int[] otherArray = new int[currenOther];
                    for (int i = 0; i < currentint; i++) {
                        if (ints[i] % 2 == 0 && ints[i] % 3 == 0) {
                            evenArray[i] = ints[i];
                        } else if (ints[i] % 2 != 0 && ints[i] % 3 == 0) {
                            oddArray[i] = ints[i];
                        } else {
                            otherArray[i] = ints[i];
                        }
                    }
                    for (int i = 0; i < evenArray.length; i++) {
                        for (int j = 0; j < evenArray.length; j++) {
                            if (ints[i] > ints[j]) {
                                int temp = ints[i];
                                ints[i] = ints[j];
                                ints[j] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < currenOdd; i++) {
                        for (int j = 0; j < oddArray.length; j++) {
                            if (ints[i] > ints[j]) {
                                int temp = ints[i];
                                ints[i] = ints[j];
                                ints[j] = temp;
                            }
                        }
                    }
                    for (int i = 0; i < otherArray.length-1; i++) {
                        for (int j = 0; j < otherArray.length; j++) {
                            if (ints[i] > ints[j]) {
                                int temp = ints[i];
                                ints[i] = ints[j];
                                ints[j] = temp;
                            }
                        }
                    }
                    currentint = 0;
                    for (int i = 0; i < evenArray.length; i++) {
                        ints[i] = evenArray[i];
                        currentint++;
                    }
                    ;
                    for (int i = 0; i < otherArray.length; i++) {
                        ints[i] = otherArray[i];
                        currentint++;
                    }
                    for (int i = 0; i < oddArray.length; i++) {
                        ints[i] = oddArray[i];
                        currentint++;
                    }
                    System.out.println();
                    break;
                case 8:
//                    8. Nhập giá trị m từ bàn phím,
//                        chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí
                    for (int i = 0; i < currentint; i++) {
                        for (int j = 0; j < currentint; j++) {
                            if (ints[i] > ints[j]) {
                                int temp = ints[i];
                                ints[i] = ints[j];
                                ints[j] = temp;
                            }
                        }
                    }
                    System.out.println("Nhập giá trị mới: ");
                    int m = Integer.parseInt(sc.nextLine());
                    int insertcurrent = 0;
                    for (int i = 0; i < currentint; i++) {
                        if (m >= ints[i]) {
                            insertcurrent = i;
                            break;
                        }
                    }
                    for (int i = currentint; i > insertcurrent; i--) {
                        ints[i] = ints[i - 1];
                    }
                    ints[insertcurrent] = m;
                    currentint++;
                    System.out.println();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập lại!!!");
                    break;
            }
        } while (true);
    }
}