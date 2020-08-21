package faceoffer.III;

import aspect.FunctionRunner;
import structure.TreeNode;

/**
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 */
public class MirrorTree27 {

    public static void main(String args[]){

        new FunctionRunner(() ->{
            TreeNode t1 = TreeNode.buildIntegerTree(1,5,6,1,7,5,4,5,1);
            System.out.println(new MirrorTree27().mirrorTree(t1));
        }).run();
    }
    /**
     * 直接递归做个交换
     * */
    public TreeNode mirrorTree(TreeNode root) {
        return mirror(root);
    }
    public TreeNode mirror(TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode t = node .left;
        node.left  = mirror(node.right);
        node.right = mirror(t);
        return node;
    }

}
