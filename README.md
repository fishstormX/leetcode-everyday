# leetCode-everyday
日常总结做的leetcode编程题，将解题思路和代码整理起来 多解会比较执行的效率
:sparkles:
运行每个类中的main函数可以执行给定的测试用例，利用AOP统计了用时

#### 相关数据结构
- :small_blue_diamond:[链表 ListNode](src/main/java/leetcode/structure/ListNode.java)  
- :small_orange_diamond:[二叉树 TreeNode](src/main/java/leetcode/structure/TreeNode.java)  [前中后序遍历](src/main/java/leetcode/structure/binaryTree)

#### 题型和题解  

1: [两数之和](src/main/java/leetcode/TwoSum1.java)  
2: [两数相加](src/main/java/leetcode/AddTwoNumber2.java)  
3: [无重复字符最长子串](src/main/java/leetcode/lengthOfLongestSubString3.java)  

---

### 剑指Offer
3: [数字中的重复数字](src/main/java/faceoffer/FindRepeatNumber3.java)  
4: [二维数组中的查找](src/main/java/faceoffer/FindNumberIn2DArray4.java)  
5：[替换空格](src/main/java/faceoffer/ReplaceSpace5.java)
6：[从尾到头打印链表](src/main/java/faceoffer/ReversePrint6.java)

---

### 按算法分类
#### DFS
深度优先  
多数是基于Stack进行的操作，对于树结构，可能使用合理的递归时间复杂度更好一些

104: [二叉树的最大深度](src/main/java/leetcode/dfs/MaximumDepthOfBinaryTree104.java)  
872: [叶子相似的树](src/main/java/leetcode/dfs/LeafSimilarTrees872.java)  
4-12: [求和路径](src/main/java/leetcode/dfs/PathsWithSumLcci04A12.java)  
98: [验证二叉搜索树](src/main/java/leetcode/dfs/ValidateBinarySearchTree98.java)  


#### BFS
广度优先  
多数是基于Queue进行的操作

1306: [跳跃游戏III](src/main/java/leetcode/bfs/JumpGameIII1306.java)  
16-19: [水域大小](src/main/java/leetcode/bfs/pondSizesLcc16A19.java)  
127: [单词接龙](src/main/java/leetcode/bfs/WordLadder127.java)  
107: [二叉树的层次遍历II](src/main/java/leetcode/bfs/BinaryTreeLevelOrderTraversalII107.java)  

#### DP
动态规划

62: [不同路径](src/main/java/leetcode/dp/HouseRobberII213.java)
213: [打家劫舍II](src/main/java/leetcode/dp/HouseRobberII213.java)