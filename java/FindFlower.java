import java.util.ArrayList;

public class FindFlower{
    public static void main(String[] args) {
        ArrayList nums = new ArrayList<Integer>();
        for (int i = 100; i<1000;i++){
            int d1 = i/100;
            int d2 = (i-d1*100)/10;
            int d3 = i-d1*100-d2*10;
            if (i == d1*d1*d1+d2*d2*d2+d3*d3*d3){
                nums.add(i);
            }
        }
        System.out.println(nums);
    }
}