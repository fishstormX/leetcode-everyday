package structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class  TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T x) { val = x; }
    public String toString(){
        String s = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while(queue.size()>0){
            for(int i =queue.size();i>0;i--){
                TreeNode treeNode = queue.poll();
                if(null!=treeNode){
                    s += treeNode.val+" ";
                    queue.offer(treeNode.left);
                    queue.offer(treeNode.right);
                }else{
                    s += "null ";
                }
            }
            s += "\n";
        }
        return s;
    }

    public static TreeNode<Integer> buildIntegerTree(Integer... nodes){
        TreeNode<Integer> treeNode = new TreeNode<>(nodes[0]);
        TreeNode<Integer> root = treeNode;
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(treeNode);
        for(int i=1;i<nodes.length;i++){
            if(i%2==1){
                treeNode = queue.poll();
                if(null!=nodes[i]){
                    TreeNode tmp = new TreeNode<Integer>(nodes[i]);
                    treeNode.left = tmp;
                    queue.offer(tmp);
                }
            }else{
                if(null!=nodes[i]) {
                    TreeNode tmp = new TreeNode<Integer>(nodes[i]);
                    treeNode.right = tmp;
                    queue.offer(tmp);
                }
            }
        }
        return root;
    }
}
