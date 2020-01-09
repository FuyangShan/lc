```java
class Solution {
    public int maxProfit(int k, int[] prices) { 
        if (k >= prices.length / 2) { // if k >= n/2, then you can make maximum number of transactions
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
                if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
            return profit;
        }
        
        int[] hold = new int[k + 1];
        int[] sold = new int[k + 1];                                 //day 0, sold[] -> the profit of having all stock[1...k] sold is 0, sold[0] = 0
        for (int i = 0; i < k + 1; i++) hold[i] = Integer.MIN_VALUE; //day 0, hold[] -> the profit of holding all stock[1...k] is INT_MIN, you would hold any new stock from day 1
        
        for (int i : prices) { //loop thru days
            for (int j = k; j >= 1; j--) { //stock[1...k]
                sold[j] = Math.max(sold[j], hold[j] + i);       //the profit of having stock[j] sold, either keep sold since yesterday or sell it out today
                hold[j] = Math.max(hold[j], sold[j - 1] - i);   //the profit of holding stock[j], either holding it since yesterday or buy it in today
                                                                //... you have to have sold the previous stock[j - 1] to buy in the stock[j]
            }
        }
        
        return sold[k];
    }
}
```