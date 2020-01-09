public class FindMath{
    public static void main(String[] args) {
        int a = 0;
        int b;
        int x;
        int y;
        while (true){
            b = 8-a;
            x = 14-a;
            y = 2+a;
            if (14-a == 8+a){
                break;
            };
            a++;
        }
        System.out.println(a + " " + b + " " + x + " " + y);
    }
}