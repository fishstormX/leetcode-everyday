package leetcode.structure.binaryTree;

import leetcode.structure.TreeNode;
import util.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历：L-R-D
 * 即 左-右-根
 *           5
 *          / \
 *        3    6
 *      / \    \
 *     2   4    8
 *  /         / \
 * 1          7   9
 *
 * */
public class LRD {
    public static void main(String[] args){
        Integer [] nodes= {5,3,6,2,4,null,8,1,null,null,null,7,9};
        TreeNode<Integer> tree = TreeUtil.buildIntegerTree(nodes);
        System.out.println(new LRD().inorderTraversal(tree));
    }

    private List<Integer> inorderTraversal(TreeNode<Integer> root){
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        return vals;
    }
    private void inorder(TreeNode<Integer> node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        inorder(node.right, vals);
        vals.add(node.val);
    }


}
