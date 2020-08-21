package faceoffer.III;

import aspect.FunctionRunner;
import structure.ListNode;
import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 *
 */
public class IsSubStructure26 {

    public static void main(String args[]){

        new FunctionRunner(() ->{
            TreeNode t1 = TreeNode.buildIntegerTree(1,5,6,1,7,5,4,5,1);
            TreeNode t2 = TreeNode.buildIntegerTree(1,5,1);
            System.out.println(new IsSubStructure26().isSubStructure(t1,t2));
        }).run();
    }
    /**
     * 递归去比较
     * */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null||B==null){
            return false;
        }

        if(A.val == B.val){
            if(compare(A,B)){
                return true;
            }
        }
        return (isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }


    /**
     * x是主要的树
     */
    private boolean compare(TreeNode x,TreeNode y ){
        if(y==null){
            return true;
        }
        if(x==null){
            return false;
        }
        if(x.val != y.val){
            return false;
        }
        return(compare(x.left,y.left)&&
                compare(x.right,y.right));
    }


}
