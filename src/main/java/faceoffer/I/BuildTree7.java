package faceoffer.I;

import aspect.FunctionRunner;
import structure.TreeNode;

import java.util.Arrays;

/**
 *   输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 * */
public class BuildTree7 {

    public static void main(String args[]){
        new FunctionRunner(() ->{
            int[] preorder = {3,9,20,15,7};
            int[] inorder = {9,3,15,20,7};
            System.out.println(new BuildTree7().buildTree(preorder,inorder));
        }).run();

    }
    /**
     *  考虑例题，在前序遍历很容易知道3是根节点,从而能分割出中序遍历的左右子树
     *  不难得出结论 3的左子树中序遍历为[9]，右子树中序遍历为[15,20,7]
     *  从而按数量分割前序遍历，3的左子树前序遍历为[9]，右子树遍历为[20,15,7]
     *  依此类推进行递归，结束条件是当前序遍历为空时返回空，为单一元素时返回单一节点
     *
     *  注意：此种方式的时间复杂度其实不乐观，因为有Arrays.copyOfRange的处理，可以建立一个额外的方法保留原Array 然后只传两index
     * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0){
            return null;
        }
        TreeNode tree= new TreeNode(preorder[0]);
        if(preorder.length==1){
            return tree;
        }
        int l =preorder.length;
        for(int i=0;i<l;i++){
            if(inorder[i]==preorder[0]){
                if(i==0){
                    tree.right = buildTree(Arrays.copyOfRange(preorder,i+1,l),Arrays.copyOfRange(inorder,i+1,l));
                }else if(i==l-1){
                    tree.left = buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                }else{
                    tree.left = buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
                    tree.right = buildTree(Arrays.copyOfRange(preorder,i+1,l),Arrays.copyOfRange(inorder,i+1,l));
                }
                break;
            }
        }
        return tree;
    }
}
