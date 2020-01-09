# 序列型 动态规划总结
---
- 给定一个序列
- 求经过n个元素之后的状态

## 解决步骤
1. 确定状态：动态规划中的状态方程 dp[i]表示 前i个元素a[0], a[1], ... , a[i - 1] 的某种性质
2. 初始化: dp[0]的值表示经过(前0个)元素之后的状态
3. 最终结果: dp[n]的值表示经过(前n个)元素之后的状态
4. 空间优化: 利用原数组 或 若干个对后续结果有影响的 prev 作为上一轮/若干轮的缓存

## 状态-序列型：
- 考虑子问题时， 每一步的选择依赖于前一步的某种状态，
- 可以记录下这一步的状态，为下一步的考虑提前做准备
- 可以利用单个或者若干个Prev作为状态的缓存，减少空间复杂度

## 最长-序列型：
- 要求找出符合条件的最长序列
- 记录以每个元素i结尾的最长子序列的长度
- 计算时，枚举在i之前子序列上一个元素是哪个

## 代表例题：
* [256. Paint House](paint-house.md)
* [255. Paint House II](paint-house-ii.md)
* [198. House Robber](house-robber.md)
* [213. House Robber II](house-robber-ii.md)
* [300. Longest Increasing Subsequence](longest-increasing-subsequence.md)
* [354. Russian Doll Envelopes](russian-doll-envelopes.md)
* [70. Climbing Stairs](climbing-stairs.md)
* [121. Best Time to Buy and Sell Stock](best-time-to-buy-and-sell-stock.md)
* [122. Best Time to Buy and Sell Stock II](best-time-to-buy-and-sell-stock-ii.md)
* [123. Best Time to Buy and Sell Stock III](best-time-to-buy-and-sell-stock-iii.md)
* [188. Best Time to Buy and Sell Stock IV](best-time-to-buy-and-sell-stock-iv.md)
* [309. Best Time to Buy and Sell Stock with CoolDown](best-time-to-buy-and-sell-stock-with-cooldown.md)
* [338. Counting Bits 没解决](counting-bits.md)
