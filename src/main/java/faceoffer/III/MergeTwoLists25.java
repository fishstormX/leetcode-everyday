package faceoffer.III;

import aspect.FunctionRunner;
import structure.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 *
 * */
public class MergeTwoLists25 {
    public static void main(String args[])  {
        int a[] = {1,2,4,6,9};
        int b[] = {1,2,3,5,6,7,8};
        ListNode listNode = ListNode.createNodeList(a);
        ListNode listNode2 = ListNode.createNodeList(b);
        new FunctionRunner(() ->{
            ListNode.printNodeList(new MergeTwoLists25().mergeTwoLists(listNode,listNode2));
        }).run();
    }

    /**
     * 另起一个队列
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode root = new ListNode(-1);
        ListNode result = root;

        while(l1!=null&&l2!=null){
            if(l1.val>l2.val){
                root.next = new ListNode(l2.val);
                l2=l2.next;
                root= root.next;
            }else{
                root.next = new ListNode(l1.val);
                l1=l1.next;
                root= root.next;
            }
        }
        if(l1==null){
            root.next=l2;
        }
        if(l2==null){
            root.next=l1;
        }
        return result.next;
    }
}
