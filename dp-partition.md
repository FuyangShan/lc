# 划分型 动态规划总结
--- 
- 给定一个序列，数字，或字符串
- 求划分成若干满足要求的片段的可行性，方式数，最值

## 解决步骤
1. 确定状态：
    - 关注最后一步 -> 最后一段
    - 从最后一段的起点开始枚举可能性
    - 用f[i] 表示前 i 个元素分段后的状态
2. 初始化： f[0] 表示空串时划分的状态（最值，可行性。。。）
3. 最终结果： f[n] 表示整个序列被划分的状态（最值，可行性。。。）

## 代表例题
* [91. Decode Ways](decode-ways.md)
* [279. Perfect Squares](perfect-squares.md)
* [221. Maximal Square](maximal-square.md)
* [132. Permutation Partioning II](palindrome-partitioning-ii.md)