package faceoffer.IV;

import aspect.FunctionRunner;
import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 *  
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
 *
 * */
public class TreeToDoublyList36 {

    public static void main(String args[]){

        new FunctionRunner(() ->{
            Node root = new Node(4);
            root.left=new Node(2);
            root.right=new Node(5);
            root.left.left=new Node(1);
            root.left.right=new Node(3);
            Node newRoot = new TreeToDoublyList36().treeToDoublyList(root);
            for(int i =0;i<6;i++){
                System.out.print(newRoot.val+"    ");
                newRoot = newRoot.right;
            }
            System.out.print("……");
            System.out.println("进入循环");
        }).run();
        new FunctionRunner(() ->{
            Node root = new Node(4);
            root.left=new Node(2);
            root.right=new Node(5);
            root.left.left=new Node(1);
            root.left.right=new Node(3);
            Node newRoot = new TreeToDoublyList36().treeToDoublyList2(root);
            for(int i =0;i<6;i++){
                System.out.print(newRoot.val+"    ");
                newRoot = newRoot.right;
            }
            System.out.print("……");
            System.out.println("进入循环");
        }).run();

    }


    //保存一个最终要返回的对象
    private Node rooter =null;
    //保存一个当前正遍历的节点
    private Node last =null;
    /**
     * 符合题意的解法，没有额外立空间，时间复杂度也更低
     * 搜索树的先序遍历就是有序的
     * */
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return  null;
        }
        buildList(root);
        rooter.left = last;
        last.right = rooter;
        return rooter;

    }
    public void buildList(Node nowa){
        if(null==nowa){
            return ;
        }
        buildList(nowa.left);
        //初始
        if(null==last){
            rooter = nowa;
            last = nowa;
        //递归循环
        }else{
            last.right = nowa;
            nowa.left = last;
            last = nowa;
        }
        buildList(nowa.right);
    }




    /**
     * 先生成一个list，时间空间复杂度都略高
     * 但是经典递归 更好理解
     * */
    public Node treeToDoublyList2(Node root) {
        if(root==null){
            return  null;
        }
        List<Node> list = new ArrayList<Node>();
        buildList(list,root);
        root = list.get(0);
        Node pre = root;
        Node now = root;
        for(int i =1;i<list.size();i++){
            now.right = list.get(i) ;
            list.get(i).left = now;
            now=list.get(i);
        }
        now.right = root;
        root.left = now;
        return root;
    }
    public void buildList(List<Node> list,Node nowa){
        if(null==nowa){
            return;
        }
        buildList(list,nowa.left);
        list.add(nowa);
        buildList(list,nowa.right);
    }
}
