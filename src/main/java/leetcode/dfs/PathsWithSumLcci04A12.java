package leetcode.dfs;

import aspect.FunctionRunner;
import structure.Pair;
import structure.TreeNode;
import util.TreeUtil;

import java.util.Stack;
/**
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：
 *
 * 节点总数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paths-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class PathsWithSumLcci04A12 {

    public static void main(String[] args){
        TreeNode tree = TreeUtil.buildIntegerTree(5,4,8,11,null,13,4,7,2,null,null,5,1);
        new FunctionRunner(() ->{
            System.out.println(new PathsWithSumLcci04A12().pathSum(tree,22));
        }).run();
    }

    public int pathSum(TreeNode<Integer> root, int sum) {
        int result = 0;
        if(null==root){
            return 0;
        }
        Stack<Pair<TreeNode<Integer>,Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root,root.val));
        while(!stack.isEmpty()){
            Pair<TreeNode<Integer>,Integer> pair = stack.pop();
            result+=checkSum(pair.getKey(),sum);
            if(null!=pair.getKey().left){
                stack.push(new Pair<>(pair.getKey().left,pair.getValue()+pair.getKey().left.val));
            }
            if(null!=pair.getKey().right){
                stack.push(new Pair<>(pair.getKey().right,pair.getValue()+pair.getKey().right.val));
            }
        }
        return result;
    }

    public int checkSum(TreeNode<Integer> root, int sum) {
        int result = 0;
        if(null==root){
            return 0;
        }
        Stack<Pair<TreeNode<Integer>,Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root,root.val));
        while(!stack.isEmpty()){
            Pair<TreeNode<Integer>,Integer> pair = stack.pop();
            if (sum == pair.getValue()) {
                result++;
            }
            if(null==pair.getKey().left&&null==pair.getKey().right){
                continue;
            }
            if(null!=pair.getKey().left){
                stack.push(new Pair<>(pair.getKey().left,pair.getValue()+pair.getKey().left.val));
            }
            if(null!=pair.getKey().right){
                stack.push(new Pair<>(pair.getKey().right,pair.getValue()+pair.getKey().right.val));
            }
        }
        return result;
    }
}
