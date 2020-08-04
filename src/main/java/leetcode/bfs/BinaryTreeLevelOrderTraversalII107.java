package leetcode.bfs;

import aspect.FunctionRunner;
import aspect.ListUtil;
import leetcode.structure.TreeNode;
import util.TreeUtil;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class BinaryTreeLevelOrderTraversalII107 {

    public static void main(String[] args){
        Integer[] arr = {3,9,20,null,null,15,7};
        System.out.println("测试用例：");
        ListUtil.printArray(arr);
        TreeNode<Integer> treeNode = TreeUtil.buildIntegerTree(arr);
        new FunctionRunner(() ->{
            BinaryTreeLevelOrderTraversalII107 binaryTreeLevelOrderTraversalII107 = new BinaryTreeLevelOrderTraversalII107();
            System.out.println(binaryTreeLevelOrderTraversalII107.levelOrderBottom(treeNode));
        }).run();

    }

    public List<List<Integer>> levelOrderBottom(TreeNode<Integer> root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
        queue.offer(root);
        int i = 1;
        int j = 0;
        List<List<Integer>> result= new ArrayList<>();
        while(true){
            List<Integer> list0 = new ArrayList<Integer>();
            TreeNode<Integer> node ;
            while(i>0){
                node = queue.poll();
                list0.add(node.val);
                i--;
                if(null!=node.left){
                    queue.offer(node.left);
                    j++;
                }
                if(null!=node.right){
                    queue.offer(node.right);
                    j++;
                }

            }
            i=j;
            result.add(list0);
            if(j==0){
                break;
            }
            j=0;
        }
        Collections.reverse(result);
        return result;
    }
}
