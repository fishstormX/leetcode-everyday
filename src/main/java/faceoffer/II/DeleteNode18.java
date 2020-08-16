package faceoffer.II;

import aspect.FunctionRunner;
import structure.ListNode;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * 示例 1:
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 示例 2:
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.。
 * */
public class DeleteNode18 {

    public static void main(String args[]){
        new FunctionRunner(() ->{
            int a [] = {4,5,1,9};
            ListNode listNode = ListNode.createNodeList(a);
            System.out.println();
            ListNode.printNodeList(listNode);
        }).run();

    }

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            return head.next;
        }
        ListNode h = head;
        ListNode tmp = head;
        head = head.next;
        while(head.val!=val){
            tmp = head;
            head = head.next;
        }
        tmp.next = head.next;
        return h;
    }
}
