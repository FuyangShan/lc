import java.util.Arrays;

public class FindLowest{
    public static void main(String[] args) {
        int[] myArray = new int[5];
        for (int i = 0;i<myArray.length;i++){
            myArray[i] = (int)(Math.random()*100);
        }
        int min = myArray[0];
        for (int j = 0;j<myArray.length;j++){
            
            if (myArray[j] < min){
                min = myArray[j];
            }

        }
        System.out.println("数组为" + Arrays.toString(myArray) + ":" + "最小值为" + min);
    }
}
