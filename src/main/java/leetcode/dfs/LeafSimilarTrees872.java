package leetcode.dfs;

import aspect.FunctionRunner;
import structure.TreeNode;
import util.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *             3
 *          /    \
 *        5       1
 *      / \      / \
 *     6   2   9    8
 *       / \
 *       7  4
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class LeafSimilarTrees872 {

    public static void main(String[] args){
        TreeNode tree1 = TreeUtil.buildIntegerTree(3,5,1,11,4,9,8,6,7,null,null,null,null,null,null);
        TreeNode tree2 = TreeUtil.buildIntegerTree(3,5,1,6,2,9,8,null,null,7,4,null,null,null,null);
        new FunctionRunner(() ->{
            boolean flag = new LeafSimilarTrees872().leafSimilar(tree1,tree2);
            System.out.println(flag);
        }).run();
    }
    public boolean leafSimilar(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1,list1);
        inorder(root2,list2);
        System.out.println("树1的叶值序列为"+list1);
        System.out.println("树2的叶值序列为"+list2);
        return  list1.equals(list2);
    }
    public void inorder(TreeNode<Integer> treeNode, List<Integer> list){
        if (treeNode == null) {
            return;
        }
        inorder(treeNode.left,list);
        if(treeNode.left==null&&treeNode.right==null){
            list.add(treeNode.val);
        }
        inorder(treeNode.right,list);
    }
}
