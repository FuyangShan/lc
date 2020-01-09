# 坐标型动态规划总结
--- 
- 给定输入为序列或者网格/矩阵
- 要求从起点到终点过程后的状态（方式数，最值）
    
## 解决步骤 

1. 确定状态：动态规划状态下标为序列下标i或者网格坐标(i, j)
> f[i]: 以第i个元素结尾的某种性质
> f[i][j]: 到格子(i, j)的路径的性质
2. 初始化: f[0] / f[0][0...n - 1]
3. 最终结果 f[n - 1] / f[m - 1][n - 1]
4. 空间优化： 如果f[i][j]的值只依赖于当前行和前一行，则可以用滚动数组节省空间

## 代表例题：
* [55. Jump Game](jump-game.md)
* [45. Jump Game II](jump-game-ii.md)
* [62. Unique Paths](unique-paths.md)
* [63. Unique Paths II](unique-paths-ii.md)
* [174. Dungeon Game](dungeon-game.md)
* [64. Minimum Path Sum](minimum-path-sum.md)
* [53. Maximum Sum of Subarray](maximum-subarray.md)
* [152. Maximum Product of Subarray](maximum-product-subarray.md)
* [674. Longest Continuous Increasing Subsequence](longest-continuous-increasing-subsequence.md)
