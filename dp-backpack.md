# 背包型 动态规划
---
1. 你有一个背包, 有最大承重
2. 商店里有若干物品, 免费拿
3. 每个物品有重量和价值
4. 目标：
> 不撑爆背包的前提下
>
> 装下最多重量物品
> 装下最大总价值物品
> 有多少种方式正好带走满满一书包物品

## 关键思路
- 关注最后一步：最后一个物品是否进入背包
- 情况 1 : 如果前 N-1 个物品能拼出重量 W, 那么前 N 个物品也能拼出重量 W
- 情况 2 : 如果前 N-1 个物品能拼出 W - An-1, 再加上最后一个物品（An-1)，能拼出重量 W
- 最后一步状态由两情况决定 f[n][w] = State(f[n - 1][w], f[n - 1][w - A[n - 1]])
    > State：True/False, Sum, Min, Max...

## 解决步骤
1. 确定状态： f[i][j] 表示前 i 个元素装成重量 j 的状态（可行数, 可行性, 总价值。。。）
2. 初始化： f[0][j] 表示 0 个元素装成 0, 1, 2, ... , j, ..., target 的状态
3. 边界情况: f[i - 1][j - Ai-1] 只能在 j >= Ai-1 时使用
4. 最终结果： f[n][target] 表示前 n 个元素装成重量 target 的状态
    > 可能需要遍历 f[n][0...target] 里的最值
5. 空间优化： 利用（一个, 或两个）滚动数组来记录 i-1 个元素行 0...target的状态

## 代表例题
* [LN 92. Backpack](backpack.md)
* [LN 125. Backpack II](backpack-ii.md)
* [LN 440. Backpack III](backpack-iii.md)
* [LN 564. Backpack IV](backpack-iv.md)
* [LN 563. Backpack V](backpack-v.md)
* [322. Coin Change](coin-change.md)
* [518. Coin Change II 没解决](coin-change-ii.md)
* [416. Partition Equal Subset Sum 没解决](partition-equal-subset-sum.md)
* [474. Ones and Zeroes 没解决](ones-and-zeroes.md)
* [1049. Last Stone Weight II 没解决](last-stone-weight-ii.md)
* [343. Integer Break 没解决](integer-break.md)
* [871. Minimum Number of Refueling Stops 没解决](minimum-number-of-refueling-stops.md)
