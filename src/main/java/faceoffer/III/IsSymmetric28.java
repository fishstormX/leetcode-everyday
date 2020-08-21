package faceoffer.III;

import aspect.FunctionRunner;
import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *  
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 *
 *
 */
public class IsSymmetric28 {

    public static void main(String args[]){

        new FunctionRunner(() ->{
            TreeNode t1 = TreeNode.buildIntegerTree(2,3,3,4,5,5,4,7,9,8,3,3,8,9,7,1,2,5,6,7,4);
            System.out.println(new IsSymmetric28().isSymmetric(t1));
        }).run();
        new FunctionRunner(() ->{
            TreeNode t1 = TreeNode.buildIntegerTree(2,3,3,4,5,5,4,7,9,8,3,3,8,9,7,1,2,5,6,7,4);
            System.out.println(new IsSymmetric28().isSymmetric2(t1));
        }).run();
    }

    /**
     * 直接递归来解 更快一些
     * */
    public boolean isSymmetric(TreeNode<Integer> root) {
        if(root==null){
            return true;
        }else{
            return isSymmetric(root.left,root.right);
        }
    }

    private boolean isSymmetric(TreeNode<Integer> root1,TreeNode<Integer> root2) {
        if(root1!=null&&root2!=null){
            if(root1.val!=root2.val){
                return false;
            }else{
                return isSymmetric(root1.left,root2.right)&&isSymmetric(root1.right,root2.left);
            }
        }else{
            if(root1!=null||root2!=null){
                return false;
            }else{
                return true;
            }
        }
    }

    /**
     *  直接通过层次遍历去逐层比较，但是慢在了queue这个数据结构上
     * */
    public boolean isSymmetric2(TreeNode<Integer> root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
        q.offer(root.left);
        q.offer(root.right);
        boolean flag =false;
        while(q.size()>0){
            flag =false;
            int[] is = new int[q.size()];
            int c=q.size();
            for(int i =0;i<c;i++){
                TreeNode<Integer> x = q.poll();
                if(x==null){
                    if(i >= c/2){
                        if(-1!=is[c-i-1]){
                            return false;
                        }
                    }else{
                        is[i] = -1;
                    }
                    continue;
                }else{
                    flag=true;
                    q.offer(x.left);
                    q.offer(x.right);
                    if(i >= c/2){
                        if(x.val!=is[c-i-1]){
                            return false;
                        }
                    }else{
                        is[i] = x.val;
                    }
                }

            }
            if(!flag){
                break;
            }
        }
        return true;
    }

}
