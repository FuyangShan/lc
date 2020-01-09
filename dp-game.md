# 博弈型 动态规划
---
- 博弈为两方
- 一方先下， 在一定规则下一次出招
- 如果满足一定条件， 则一方胜
- 目标取胜
    > 先手: 先出招的一方
    > 出招后，先手换人，新的先手面对一个新的局面

## 解决步骤
1. 确定状态 f[i]：面对i个元素时，先手者是否必胜
2. 初始化 f[0]: 面对0个元素时（上一轮被对手取走所有元素），己方是否胜利
3. 最终结果 f[n]: 面对n个元素时，先手者是否必胜
4. 空间优化：保存上一轮对手采取『若干种』行动之后，己方分别的状态

## 代表例题
* [292. Nim Game](nim-game.md)
* [877. Stone Game](stone-game.md)
* [810. Chalkboard XOR Game 没解决](chalkboard-xor-game.md)
* [486. Predict the Winner 没解决](predict-the-winner.md)
* [464. Can I Win 没解决](can-i-win.md)
* [1025. Divisor Game 没解决](divisor-game.md)
