import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String sortstr = str.trim().replaceAll("\\s+", "");
        String[] ints = sortstr.split(" ");
        for (int i = 0; i < ints.length / 2; i++) {
            for (int j = ints.length / 2; j < ints.length; j++) {
                if (ints[i] == ints[j]) {
                    System.out.println("là chuỗi đối xứng!");
                }else{
                    System.out.println("Không phải là chuỗi đối xứng!");
                }
            }
        }
    }
}