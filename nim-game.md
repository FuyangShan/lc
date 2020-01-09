# Nim Game
- You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
- The one who removes the last stone will be the winner. 
- You will take the first turn to remove the stones.

- Both of you are very clever and have optimal strategies for the game. 
### Q: Write a function to determine whether you can win the game given the number of stones in the heap.

>Example:

>Input: 4
>Output: false 
>Explanation: If there are 4 stones in the heap, then you will never win the game;
>             No matter 1, 2, or 3 stones you remove, the last stone will always be 
>             removed by your friend.

```java
 
// DP 
class Solution {
    public boolean canWinNim(int n) {
        if (n == 0) return false;
        if (n <= 3) return true;
        // f[i] = if first-hand can win when facing i stones
        boolean[] f = new boolean[n + 1];
        // init
        f[0] = false;
        f[1] = f[2] = f[3] = true;
        
        for (int i = 4; i <= n; i++) {
            // f[i] = {!f[i-1] || !f[i-2] || !f[i-3]}
            f[i] = !f[i - 1] || !f[i - 2] || !f[i - 3];
        }
            
        return f[n];    
    }
}

// DP in place
class Solution {
    public boolean canWinNim(int n) {
        if (n == 0) return false;
        if (n <= 3) return true;
        // if rival took 1, 2, or 3 stones, can you win?
        boolean one = true, two = true, three = true;
        boolean res = false;
        for (int i = 4; i <= n; i++) {
            // if you take 1, 2 or 3 stones, can rival win?
            // if "any" of your move causes rival lose
            // you can win!
            res = !one || !two || !three;
            // after your move
            three = two;
            two = one;
            one = res;
        }
        return res;    
    }
}
// O(1)
class Solution {
    public boolean canWinNim(int n) {
        return (n % 4 != 0);
    }
}
```
