package faceoffer.IV;

import aspect.FunctionRunner;
import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
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
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 提示：
 * 节点总数 <= 10000
 * */
public class PathSum34 {

    public static void main(String args[]){

        new FunctionRunner(() ->{
            TreeNode<Integer> integerTreeNode = TreeNode.buildIntegerTree(5,4,8,11,null,13,4,7,2,null,null,5,1);
            System.out.println((new PathSum34().pathSum(integerTreeNode,22)));
        }).run();

    }

    public List<List<Integer>> pathSum(TreeNode<Integer> root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        findPath(sum,new ArrayList(),result,root,0);
        return result;
    }
    /**
     * 逐层向下找，1.测试用例中可能有负值
     * 2. 要求的是走到最后一层的叶子节点才行
     * */
    private void findPath(int sum,List<Integer> nowa,List<List<Integer>> result,TreeNode<Integer> node,int count){
        if(null==node){
            return;
        }
        nowa.add(node.val);
        count+=node.val;
        if(count==sum&&node.left==null&&node.right==null){
            result.add(nowa);
        }else{
            /**
             * 避免list被污染，其中一组需要用new ArrayList
             * 为了节省时间复杂度 先判断
             * */
            if(node.left==null){
                findPath(sum,nowa,result,node.right,count);
            }else if(node.right==null){
                findPath(sum,nowa,result,node.left,count);
            }
            else{
                findPath(sum,new ArrayList<>(nowa),result,node.left,count);
                findPath(sum,nowa,result,node.right,count);
            }
        }
    }
}
