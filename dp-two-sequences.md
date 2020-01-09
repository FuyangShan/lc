# 双序列 动态规划
---
1. 给定两个一维序列/字符串

## 关键思路
- 关注最后一步：序列A和序列B的最后一个字符是否匹配
- 是否需要序列A/B的最后一个字符
- 缩减问题规模

## 解决步骤
1. 确定状态： f[i][j] 表示序列A前 i 个元素和序列B前 j 个元素的状态 
> 计数型 case1 + case2 + ...
> 最值型 max/min {case1, case2}
> 操作数+1, 匹配长度+1
2. 初始化： f[0][j] 表示空序列A, f[i][0] 表示空序列B 的状态
3. 边界情况: f[i - 1][j - 1] 只能在i >= 1, j >= 1 时使用
4. 最终结果： f[m][n] 表示序列A前 m 个元素和序列前 n 个元素的状态
5. 空间优化： 利用（一个, 或两个）滚动数组来记录 i-1 个元素行 0...j-1 的状态

## 代表例题
* [1143. Longest Common Subsequence](longest-common-subsequence.md)
* [97. Interleaving String](interleaving-string.md)
* [72. Edit Distance](edit-distance.md)
* [115. Distinct Subsequences](distinct-subsequences.md)
* [10. Regular Expression Matching](regular-expression-matching.md)
* [44. Wildcard Matching](wildcard-matching.md)
