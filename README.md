# leetCode-everyday
日常总结做的leetcode编程题，将解题思路和代码整理起来 多解会比较执行的效率
:sparkles:
运行每个类中的main函数可以执行给定的测试用例，利用AOP统计了用时

代码部分皆为手敲 经过一次次优化

#### 相关数据结构
- :small_blue_diamond:[链表 ListNode](src/main/java/structure/ListNode.java)  
- :small_orange_diamond:[二叉树 TreeNode](src/main/java/structure/TreeNode.java)  [前中后序遍历](src/main/java/structure/binaryTree)

#### 题型和题解  

1: [两数之和](src/main/java/leetcode/TwoSum1.java)  
2: [两数相加](src/main/java/leetcode/AddTwoNumber2.java)  
3: [无重复字符最长子串](src/main/java/leetcode/lengthOfLongestSubString3.java)  

---

### 剑指Offer
3: [数字中的重复数字](src/main/java/faceoffer/I/FindRepeatNumber3.java) 
4: [二维数组中的查找](src/main/java/faceoffer/I/FindNumberIn2DArray4.java) 
5：[替换空格](src/main/java/faceoffer/I/ReplaceSpace5.java)
6：[从尾到头打印链表](src/main/java/faceoffer/I/ReversePrint6.java)
7：[重建二叉树](src/main/java/faceoffer/I/BuildTree7.java)
9：[用两个栈实现队列](src/main/java/faceoffer/I/CQueue9.java)
10-1：[斐波那契数列](src/main/java/faceoffer/I/Fib10A1.java)
10-2：[青蛙跳台阶问题](src/main/java/faceoffer/I/Upstairs10A2.java)

11：[旋转数组的最小数字](src/main/java/faceoffer/II/MinArray11.java)
12：[矩阵中的路径](src/main/java/faceoffer/II/Exist12.java)
15：[二进制中1的个数](src/main/java/faceoffer/II/HammingWeight15.java)
17：[打印从1到最大的n位数](src/main/java/faceoffer/II/PrintNumbers17.java)
18：[删除链表的节点](src/main/java/faceoffer/II/DeleteNode18.java)  

21：[调整数组顺序使奇数位于偶数前面](src/main/java/faceoffer/III/Exchange21.java) 
22：[链表中倒数第k个节点](src/main/java/faceoffer/III/GetkthFromEnd22.java) 
23-1：[链表中环的入口节点](src/main/java/faceoffer/III/HasCircle23A1.java) 
23-2：[找到链表中环的入口](src/main/java/faceoffer/III/DetectCycle23A2.java) 
24：[反转链表](src/main/java/faceoffer/III/ReverseList24.java) 
25：[合并两个排序的链表](src/main/java/faceoffer/III/MergeTwoLists25.java) 
26：[树的子结构](src/main/java/faceoffer/III/IsSubStructure26.java) 
27：[二叉树的镜像](src/main/java/faceoffer/III/MirrorTree27.java) 
28：[对称的二叉树](src/main/java/faceoffer/III/IsSymmetric28.java) 
29：[顺时针打印矩阵](src/main/java/faceoffer/III/SpiralOrder29.java) 
30：[包含min函数的栈](src/main/java/faceoffer/III/MinStack30.java) 

31：[栈的压入、弹出序列](src/main/java/faceoffer/IV/ValidateStackSequences31.java) 

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