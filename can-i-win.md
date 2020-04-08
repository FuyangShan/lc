# 464. Can I Win 没解决

```java
class Solution {
    Map<String, Boolean> memo; // key: chosen[] to string, value: canIWinWithSituation return value when chosen to string is key
        
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= maxChoosableInteger) 
            return true;
        if (((1 + maxChoosableInteger) / 2 * maxChoosableInteger) < desiredTotal) {
            return false;
        }
        memo = new HashMap<>();
        
        return canIWinWithSituation(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1]);
    }

    private boolean canIWinWithSituation(int maxChoosableInteger, int curDesiredTotal, boolean[] chosen) {
        
        if (curDesiredTotal <= 0) { 
            return false;
        }
        
        String chosenSerialization = Arrays.toString(chosen);
        if (memo.containsKey(chosenSerialization)) {
            return memo.get(chosenSerialization);
        }
        
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (chosen[i]) continue;
            chosen[i] = true;
            if (!canIWinWithSituation(maxChoosableInteger, curDesiredTotal - i, chosen)) {
                memo.put(chosenSerialization, true);
                chosen[i] = false;
                return true;
            }
            chosen[i] = false;
        }
        memo.put(chosenSerialization, false);
        return false;
    }
}
```