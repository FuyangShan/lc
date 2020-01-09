# 区间型 动态规划
---
    - 给定一个序列/字符串， 进行一些操作
    - 最后一步会将序列/字符串去头/去尾
    - 剩下的会是一个区间[i, j]
    - 状态定义为 f[i][j],表示面对子序列[i, ..., j]时的最优性质
    - 计算顺序：按照长度 j - i从小到大的顺序去算
    
## 关键思路
- 关注最后一步：最后只剩头尾两个元素时的状态
- 情况 1 : 如果去头，则状态为 **去头的状态 + 剩下的状态**
- 情况 2 : 如果去尾，则状态为 **去尾的状态 + 剩下的状态**
- 最后一步状态由两种情况决定 f[i][j] = State(f[i - 1][j], f[i + 1][j])
    > State：True/False, Sum, Min, Max...

## 解决步骤
1. 确定状态： f[i][j] 表示序列下标从 i,..., j 的状态（可行数, 可行性, 总价值。。。）
2. 初始化： f[i][i] / f[i][i+1] 表示 序列下标 i 或者 i, i+1 的状态
3. 最终结果： f[0][n-1] 表示序列下标从 0, ..., n-1 的状态

## 代表例题
* [5. Longest Palindromic Substring](longest-palindromic-substring.md)
* [516. Longest Palindromic Subsequence](longest-palindromic-subsequence.md)
* [877. Stone Game](stone-game.md)
* [87. Scramble String](scramble-string.md)
* [312. Burst Balloons](burst-balloons.md)
