package structure.binaryTree;

import structure.TreeNode;
import util.TreeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历：D-L-R
 * 即 根-左-右
 *           5
 *          / \
 *        3    6
 *      / \    \
 *     2   4    8
 *  /         / \
 * 1          7   9
 *
 * */
public class DLR {
    public static void main(String[] args){
        Integer [] nodes= {5,3,6,2,4,null,8,1,null,null,null,7,9};
        TreeNode<Integer> tree = TreeUtil.buildIntegerTree(nodes);
        System.out.println(new DLR().inorderTraversal(tree));
    }

    private List<Integer> inorderTraversal(TreeNode<Integer> root){
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        return vals;
    }
    private void inorder(TreeNode<Integer> node, List<Integer> vals) {
        if (node == null) return;
        vals.add(node.val);
        inorder(node.left, vals);
        inorder(node.right, vals);
    }


}
