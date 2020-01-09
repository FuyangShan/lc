```java
class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, prev_sold = 0, hold = Integer.MIN_VALUE, prev_hold;
        for (int i : prices) {                         
            prev_hold = hold;                          //prev_hold -> the profit if you ended up holding stock from yesterday[i - 1]
            hold = Math.max(prev_sold - i, hold);      //hold      -> the profit if you ended up buying stock today, or doing nothing but holding stock from yesterday[i - 1]
                                                       //...you have to rest yesterday & keep stock sold 2-days-ago[i - 2]
            prev_sold = sold;                          //prev_sold -> the profit if you ended up keeping stock sold since yesterday[i - 1], marked for future use
            sold = Math.max(prev_hold + i, sold);      //sold      -> the profit if you ended up selling the stock today, or doing nothing but keeping stock sold since yesterday[i - 1]
                                                       //...you have to hold stock yesterday[i - 1] to sell it today
        }
        return sold; //Getting thru all days, the maxProfit of having all trasaction done, in other words, all stock sold
    }
}
```