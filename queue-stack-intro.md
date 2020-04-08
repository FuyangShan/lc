# Queue Stack

## 1. How could we implement a queue by using two stacks?
- Solution: 
    - Stack1: to buffer all new elements.    -> push(x) into stack1
    - Stack2: to pop out the 1st element
        - if stack2 is empty, we move all elements from s1 to s2, then pop out
        - if stack2 is not empty, we pop out the top of s2
- Time: 
    - Push() -> O(1)
    - Pop()  -> O(1,1,1,1....n) (when empty, s1-to-s2 -> O(n)) 
    - Amortized time complexity = O(1)

## 2. How could we implement min() function when using stack with O(1);
- Solution:
    - Stack1: to buffer all new elements.
    - Stack2: to buffer the min element so far
        - if push(x) < min, push(x) to s2
        - if pop(x) == min, pop() from s2

## 3. How to sort numbers with two stacks
- Solution: selection sort
    - stack1: to buffer unsorted numbers
    - stack2: to buffer smallest number at each iteration
    - 1. move s1 to s2 and calculate the global_min
    - 2. keep pop() from s2 back to s1, push global_min back to s2, finish current iteration
    - 3. move s1 to s2 and calculate the gloabl_min
    - 4. keep pop() from s2 back to s1 (until s2.size == s2.initial_size_before_this_iteration)
    - 5. keep doing until s2 has all elements sorted
- Follow Up: what if there are duplicate element?

## 4. How to use multiple stacks to implement a deque
- Solution: 
    - Stack1: to buffer left half of queue, poll queue head from s1 top
    - Stack2: to buffer right half of queue, poll queue tail from s2 top
    - Stack3: to buffer temp elements from s1
    - 1. s1 move half elements to s3. (head half reversed temporarily in s3)
    - 2. s1 move remaining half to s2. (tail half reversed in s2)
    - 3. s3 move back to s1. (head half in order in s1)

## 什么问题考虑stack？
从左到右linear scan 一个array/string时， 如果要不断回头看左边最新到元素时，往往要用到stack

## 5. reversed polish notation 
> a * (b + c) -> a b c + * 
> a b c + * -> a * (b + c)
- scan "abc+*" and push numbers to stack for operation
- when found operator, pop out two numbers to calculate, and push result back to stack


* [32. Longest Valid Parentheses](longest-valid-parentheses.md)
* [232.Implement Queue with Stacks](implement-queue-using-stacks.md)
* [225. Implement Stack using Queue](implement-stack-using-queues.md)
* [155. Min Stack](min-stack.md)
* [150. Evaluate Reverse Polish Notation](evaluate-reverse-polish-notation.md)
* [20. Valid Parentheses](valid-parentheses.md)
* [682. Baseball Game](baseball-game.md)
* [921. MininumAddToMakeParenthesesValid](minimum-add-to-make-parentheses-valid.md)
* [739. Daily Temperature](daily-temperatures.md)
* [856. Score of Parentheses](score-of-parentheses.md)
* [394. Decode String](decode-string.md)
* [71. Simplify Path](simplify-path.md)
* [84. Largest Rectangle in Histogram](largest-rectangle-in-histogram.md)
* [224. Basic Calculator](basic-calculator.md)
* [16. Remove Duplicate Letters](remove-duplicate-letters.md)

