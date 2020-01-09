# Candy
- There are N children standing in a line. Each child is assigned a rating value.

- You are giving candies to these children subjected to the following requirements:

- Each child must have at least one candy.
- Children with a higher rating get more candies than their neighbors.
- What is the minimum candies you must give?

> Example 1:

> Input: [1,0,2]
> Output: 5
> Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
> Example 2:

> Input: [1,2,2]
> Output: 4
> Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
> The third child gets 1 candy because it satisfies the above two conditions.

```java
//S1
class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int sum = 0;
        
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }
}

//S2
class Solution {
    public int candy(int[] ratings) {
        int[] c = new int[ratings.length];
        Arrays.fill(c, 1);
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) c[i] = c[i - 1] + 1;
        }
        
        int sum = c[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                c[i] = Math.max(c[i + 1] + 1, c[i]);
            }
            sum += c[i];
        }
        return sum;
    }
}

//S3
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        //countdown to cache descending candies, prev to cache the last ascending candy
        int countdown = 0, prev = 1, total = 1;
        //loop from ratings[1], look left to determine if we are ascending or descending.
        for (int i = 1; i < ratings.length; i++) {
			//ascending, starting to add candies to total
            if (ratings[i] >= ratings[i - 1]) { 
				//there are CD candies not collected
                if (countdown > 0) {
                    //the last descending candy is 1, and first descending candy is CD
                    total += countdown * (countdown + 1) / 2;

                    //if CD exceeds last ascending candy, we need compensate back to last ascending candy
                    if (countdown >= prev) total += countdown - prev + 1;

                    countdown = 0; //reset CD
                    prev = 1; //reset last ascending candy
                }
                prev = ratings[i] == ratings[i - 1] ? 1 : prev + 1; //add curr ascending candy to total
                total += prev;
			// descending, counting down
            } else countdown++;
        }
        
        if (countdown > 0) { //after all, test if there is still descending candies not collected
            total += countdown * (countdown + 1) / 2; 
            if (countdown >= prev) total += countdown - prev + 1;
        }
        
        return total;
    }
}
```
