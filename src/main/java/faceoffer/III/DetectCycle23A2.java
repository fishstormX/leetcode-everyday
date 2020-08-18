package faceoffer.III;

import aspect.FunctionRunner;
import structure.ListNode;

/**
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
class DetectCycle23A2 {

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
            System.out.println(new DetectCycle23A2().detectCycle(listNode1).val);
        }).run();
    }



    /**
     * 参考23A1，可以先判断出来是否相遇以及拿到相遇点，这部分可以复用
     * 我们将链表分割成两部分 环和环前链表（不含交叉点） 设定其节点数分别为a 和b
     * 则两个指针分别经过了 t 和 2t个节点
     * 则有 2t = t+n*b (n为正整数，即前面的指针必然比后面的指针多走了n圈)
     * 则有 t = n*b,即此时两个指针其实都恰巧走了圈数的节点数
     * 此时我们从root节点令起一个root指针，与相遇点的last指针同时向前移动
     * 在a步之后 root指针走了a步 last指针走了 a+n*b步，两指针必定相遇且相遇在交叉点
     * */
    public ListNode detectCycle(ListNode head) {
        ListNode last = head;
        ListNode root = head;
        while(head!=null){
            head = head.next;
            if(head!=null){
                head = head.next;
            }else{
                return null;
            }
            last = last.next;
            if(last==head){
                break;
            }
        }
        if(head==null){
            return null;
        }
        while(last!=root){
            root = root.next;
            last = last.next;
        }
        return last;
    }


}
