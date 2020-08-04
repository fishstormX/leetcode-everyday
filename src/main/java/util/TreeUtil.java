package util;

import leetcode.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
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
