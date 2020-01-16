public class FindMatrix{
    public static void main(String[] args) {
        int[][] matrix = {
            {1,   3,  5,  7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        int target = 6;
        int[] left = {0,0};
        int[] right = {matrix.length, matrix[matrix.length].length};
        int leftIndex = left[0] * matrix[0].length + left[1];
        int rightIndex = right[0] * right[1] + right[1];
        while (leftIndex < rightIndex){
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            int[] mid = {midIndex/matrix[0].length, midIndex%matrix[0].length};
            if (matrix[mid[0]][mid[1]] < target){
                leftIndex = midIndex + 1;
            }else{
                rightIndex = midIndex;
            }
        };
        left[0] = leftIndex/matrix[0].length;
        left[1] = leftIndex%matrix[0].length;
        if (matrix[left[0]][left[1]] == target){
            System.out.println(true);
        }else{
            System.out.println(false);
        };

        


    }
}
