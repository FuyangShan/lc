```java
public class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE; //day 0, the profit of holding 1st stock and 2nd stock are INT_MIN, meaning you would hold any stock from day 1
        int sold1 = 0, sold2 = 0;  //day 0, the profit of having 1st and 2nd stock sold is zero, meaning you would sell any stock as long as it's positive gain
        for(int i:prices){                        // Assume we only have 0 money at first
            sold2 = Math.max(sold2, hold2 + i);   // sold2 -> the maxProfit of having 2nd stock sold: sold yesterday(do nothing today) or sell it out today 
            hold2 = Math.max(hold2, sold1 - i);   // hold2 -> the maxProfit of holding 2nd stock: hold yesterday(do nothing today) or buy it in today 
            sold1 = Math.max(sold1, hold1 + i);   // sold1 -> the maxProfit of having 1st stock sold: sold yesterday(do nothing today) or sell it out today
            hold1 = Math.max(hold1, -i);          // hold1 -> the maxProfit of holding 1st stock: hold yesterday(do nothing today) or buy it in today
        }
        return sold2; //Getting thru all days, you will end up the profit whenever you sold the 2nd stock for the best profit.
    }
}
```