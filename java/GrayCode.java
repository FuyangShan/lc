/* public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < (1 << n); i++)
            result.add(i ^ (i >> 1));
        return result;
    }
}
 */

class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList();
        for (int i = 1; i <= n; i++){
            for (int j = (1<<(i-1)); j < (1<<i);j++){
                result.add(result.get((1<<i)-j-1)|(1<<i));
            }
        }
        return result;
    }
}