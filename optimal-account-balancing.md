# Optimal Account Balancing
- A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

- Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

- Note:

- A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
- Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.

> Example 1:

> Input:
> [[0,1,10], [2,0,5]]

> Output:
> 2

> Explanation:
> Person #0 gave person #1 $10.
> Person #2 gave person #0 $5.

> Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.

> Example 2:

> Input:
> [[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

> Output:
> 1

> Explanation:
> Person #0 gave person #1 $10.
> Person #1 gave person #0 $1.
> Person #1 gave person #2 $5.
> Person #2 gave person #0 $5.
> 
> Therefore, person #1 only need to give person #0 $4, and all debt is settled.

```java
class Solution {
    public int minTransfers(int[][] transactions) {
        int[] bal = balance(transactions);

		return DFS(0, bal);
    }
	// build the balance array for each id, using map
	private int[] balance(int[][] transactions) {
		// store everyone's balance in <id, bal> map
		HashMap<Integer, Integer> balanceMap = new HashMap<>();
		// travese transaction array to update balanceMap
		for (int[] trans : transactions) {
			// credit
			balanceMap.put(trans[0], balanceMap.getOrDefault(trans[0], 0) + trans[2]);
			// debt
			balanceMap.put(trans[1], balanceMap.getOrDefault(trans[1], 0) - trans[2]);
		}
		int[] bal = new int[balanceMap.size()];

		int i = 0;
		for (int amount : balanceMap.values()) {
			bal[i++] = amount;
		}

		return bal;
	}
	// Backtrack traverse the transfer solutions
	private int DFS(int start, int[] bal) {
		// special cases
		while (start < bal.length && bal[start] == 0) {
			start++;
		}

		// base case
		if (start == bal.length) {
			return 0;
		}

		// recursive case
		int min = Integer.MAX_VALUE;

		for (int i = start + 1; i < bal.length; i++) {
			// settle debt and credit
			if (bal[start] * bal[i] < 0) {
				// settle bal[start] with bal[i]
				bal[i] += bal[start];
				// bal[start] is settled, then settle bal[start+1]
				min = Math.min(min, DFS(start + 1, bal) + 1);
				// backtrack
				bal[i] -= bal[start];
			}
		}

		return min;
	}
}
```
