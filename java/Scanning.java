import java.util.Scanner;
 
public class Scanning {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        System.out.println("第一个整数："+a);
        String rn = s.nextLine();
        String b = s.nextLine();
        System.out.println("第二个字符串："+b);
    }
}
