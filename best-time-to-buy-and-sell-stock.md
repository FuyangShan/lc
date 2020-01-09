```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            min = Math.min(i, min); //find the lowest price to buy in
            profit = Math.max(profit, i - min); //find the highest price to sell out
        }
        return profit;
    }
}
```