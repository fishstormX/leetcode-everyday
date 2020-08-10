package faceoffer.I;

import aspect.FunctionRunner;
import aspect.ListUtil;
import structure.ListNode;

import java.util.Arrays;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 * */
public class ReversePrint6 {

    public static void main(String args[]){
        int [] p = {1,2,4,5,7};
        ListNode listNode =ListNode.createNodeList(p);
        new FunctionRunner(() ->{
            ListUtil.printArray(new ReversePrint6().reversePrint(listNode));
        }).run();
    }

    /**
     * 两次遍历
     * */
    public int[] reversePrint(ListNode head) {
        int [] a = new int[10000];
        int i =9999;
        while(head!=null){
            a[i]=head.val;
            i--;
            head = head.next;
        }
        //此API含前不含后
        return Arrays.copyOfRange(a,i+1,10000);
    }
}
