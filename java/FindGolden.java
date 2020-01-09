public class FindGolden{
    public int[] twoNums(){
        double div;
        int a = 1;
        int b = 1;
        double res = 0.0;
        for (double i = 1; i<21;i++){
            for (double j = 1; j<21; j++){
                if ((i%2 == 0)&&(j%2 == 0)) continue;
                div = (double)i/j;
                res = (double)a/b;
                if (Math.abs(div-0.618)<Math.abs(res-0.618)){
                    a =(int) i;
                    b =(int) j;
                }
            }
        }        
        int[]nums = {a,b};
        return nums;
    }

    public static void main(String[] args) {
        FindGolden myGolden = new FindGolden();

        System.out.println(myGolden.twoNums()[0]+","+myGolden.twoNums()[1]);
    }
}