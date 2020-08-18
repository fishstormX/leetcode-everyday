package faceoffer.III;

import aspect.FunctionRunner;
import structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *  
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class GetkthFromEnd22 {

    public static void main(String args[]){
        int a [] = {1,2,3,4,5,6,7,8,9,10,10};
        ListNode listNode = ListNode.createNodeList(a);
        new FunctionRunner(() ->{
            ListNode.printNodeList(new GetkthFromEnd22().getKthFromEnd(listNode,4));
        }).run();
        new FunctionRunner(() ->{
            ListNode.printNodeList(new GetkthFromEnd22().getKthFromEnd2(listNode,4));
        }).run();
    }



    /**
     * 通过构建双指针，在前面的指针移动k步之后，后面的同步移动，
     * 这样等到后面指针走到头时，刚好前面的是想要的位置
     * */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tmp=head;
        int i = 0;
        while(head!=null){
            head = head.next;
            i++;
            if(i>k){
                tmp=tmp.next;
            }
        }

        return tmp;
    }


    /**
     *  先遍历一次 然后用了一个list来维护链表数据，
     *  慢在了list的构建和扩容上，而且需要一套额外的空间
     *
     * */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();

        while(head!=null){
            list.add(head);
            head = head.next;
        }

        return list.get(list.size()-k);
    }
}
