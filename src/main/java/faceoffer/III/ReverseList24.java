package faceoffer.III;

import aspect.FunctionRunner;
import structure.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 * */
public class ReverseList24 {
    public static void main(String args[]) throws InterruptedException {
        int a[] = {1,2,3,4,5,6,7};
        ListNode listNode = ListNode.createNodeList(a);
        new FunctionRunner(() ->{
            ListNode.printNodeList(new ReverseList24().reverseList(listNode));
        }).run();
    }
    public ListNode reverseList(ListNode head) {

        if(head==null||head.next==null){
            return head;
        }
        ListNode x = head.next;
        ListNode headd = reverseList(head.next);
        x.next = head;
        head.next = null;
        return headd;
    }
}
