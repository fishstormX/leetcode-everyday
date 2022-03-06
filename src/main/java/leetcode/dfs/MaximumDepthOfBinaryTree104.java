package leetcode.dfs;

import aspect.FunctionRunner;
import structure.Pair;
import structure.TreeNode;
import util.TreeUtil;

import java.util.Stack;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class MaximumDepthOfBinaryTree104 {

    public static void main(String[] args){
        TreeNode tree = TreeUtil.buildIntegerTree(3,5,1,11,4,9,8,6,7,null,null,null,null,null,null);
        new FunctionRunner(() ->{
            System.out.println("深度："+new MaximumDepthOfBinaryTree104().maxDepth(tree));
        }).run();
        new FunctionRunner(() ->{
            System.out.println("\n深度："+new MaximumDepthOfBinaryTree104().maxDepth1(tree));
        }).run();
    }

    public int maxDepth1(TreeNode<Integer> root){
        Stack<Pair<TreeNode<Integer>, Integer>> stack = new Stack<>();
        if (root != null) {
            stack.push(new Pair(root, 1));
        }
        int depth = 0;
        while (!stack.isEmpty()){
            Pair<TreeNode<Integer>,Integer> pair = stack.pop();
            TreeNode<Integer> treeNode = pair.getKey();
            if(null!=treeNode){
                depth = Math.max(depth,pair.getValue());
                stack.add(new Pair<>(treeNode.left,pair.getValue()+1));
                stack.add(new Pair<>(treeNode.right,pair.getValue()+1));
            }
        }
        return depth;
    }
    /**
     * 使用递归的方式遍历,直接使用了leetcode的代码
     */
    public int maxDepth(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }

    }
}
