# H Index
- Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

- According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

> Example:

> Input: citations = [3,0,6,1,5]
> Output: 3 
> Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
> received 3, 0, 6, 1, 5 citations respectively.
> Since the researcher has 3 papers with at least 3 citations each and the remaining 
> two with no more than 3 citations each, her h-index is 3.

```java
//S1, sort & traverse
class Solution {
    public int hIndex(int[] citation) {
        int n = citation.length;
        Arrays.sort(citation);
        for (int i = 0; i < n; i++) {
            if (citation[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }
}

//S2, counting
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
		// count appearance of citations and sort in [0, 1, 2,...,n]
        for (int i : citations) {
            papers[Math.min(n, i)]++;
        }
        int citation = n;
		// aggregate paper count until citation <= count
        for (int count = papers[n]; citation > count; count += papers[citation]) {
            citation--;
        }
        return citation;
    }
}
```
