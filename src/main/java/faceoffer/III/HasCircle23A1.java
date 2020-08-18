package faceoffer.III;

import aspect.FunctionRunner;
import structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 */ class HasCircle23A1 {

    public static void main(String args[]){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next =listNode2;
        listNode2.next =listNode3;
        listNode3.next =listNode4;
        listNode4.next =listNode5;
        listNode5.next =listNode6;
        listNode6.next =listNode7;
        listNode7.next =listNode4;
        new FunctionRunner(() ->{
            System.out.println(new HasCircle23A1().hasCycle(listNode1));
        }).run();
    }



    /**
     * 通过构建双指针，在前面的指针每次移动2格，在后面的指针每次移动一格
     * 如果有环二者必然相遇
     * */
    public boolean hasCycle(ListNode head) {
        ListNode last = head;
        while(head!=null){
            head = head.next;
            if(head!=null){
                head = head.next;
            }else{
                return false;
            }

            last = last.next;
            if(last==head){
                return true;
            }
        }
        return false;
    }


}
