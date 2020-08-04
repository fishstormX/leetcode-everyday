package leetcode;

import aspect.FunctionRunner;
import aspect.FunctionTest;
import aspect.ListUtil;
import leetcode.structure.ListNode;

import java.util.function.Function;


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class AddTwoNumbers2 {

    public static void main(String args[]){

        ListNode l1=ListNode.createNodeList(new int[]{1,2,5,0,8});
        ListNode l2=ListNode.createNodeList(new int[]{3,9,5,1,7});
        System.out.print("l1    :");
        ListNode.printNodeList(l1);
        System.out.print("\nl2    :");
        ListNode.printNodeList(l2);
        AddTwoNumbers2 addTwoNumbers2 = new AddTwoNumbers2();
        final ListNode[] result = new ListNode[1];
        new FunctionRunner(() ->{
            result[0] = addTwoNumbers2.addTwoNumbers(l1,l2);
        }).run();
        System.out.print("\nresult:");
        ListNode.printNodeList(result[0]);
    }

    /**
     * 题解其实思路明确，就是链表从头加到尾，注意进1位
     * 注意：杜绝使用转链表为整形变量的方法，会导致溢出，而且需要经过多次反转，效率低
     * 遍历的方法
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int ix=0;
        int v1=0;
        int v2=0;
        boolean flag=true;
        ListNode head=new ListNode(0);
        ListNode tmp=head;
        ListNode up=head;
        while(true){
            ix=0;v1=0;v2=0;
            if(l1==null&&l2==null){
                break;
            }
            if(l1!=null){
                v1=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                v2=l2.val;
                l2=l2.next;
            }

            if(v1+v2+tmp.val>=10){
                ix=1;
            }
            tmp.val=tmp.val+v1+v2-10*ix;
            tmp.next=new ListNode(ix);
            up=tmp;
            tmp=tmp.next;
        }
        if(tmp.val!=1){
            up.next=null;
        }
        return head;
    }
}
