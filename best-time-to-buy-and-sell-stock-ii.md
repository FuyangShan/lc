```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        int prev = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prev > 0) profit += prices[i] - prev; //Harvest the gain if price today is higher than yesterday
            prev = prices[i]; //Mark down today's price for tmr
        }
        return profit;
    }
}
```