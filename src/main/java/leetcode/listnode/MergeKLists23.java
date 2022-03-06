package leetcode.listnode;

import aspect.FunctionRunner;
import leetcode.dp.UniquePaths62;
import structure.ListNode;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class MergeKLists23 {

    public static void main(String args[]){
        int size = 4;
        ListNode[] listNodes= new ListNode[10];
        for(int i =0;i<size;i++){
            //构造升序链表数组
            ListNode tmp = ListNode.createEasyRiseListNode(-i*500,i,10000*Math.abs(10-i));
            listNodes[i] = tmp;
        }
        System.out.println("========= 根据用例不同 解法会有不同的优势，比如数组较多时解法1具有优势，常规2 3 4具有优势 ==========" +
                "\n 综合时间复杂度 3必定小于2");
        new FunctionRunner(() ->{
            System.out.println("========= 解法1 ==========");
            //时间复杂度极差，不是标准解
            new MergeKLists23().mergeKLists(listNodes);
        }).run();
        for(int i =0;i<size;i++){
            //构造升序链表数组
            ListNode tmp = ListNode.createEasyRiseListNode(-i*500,i,10000*Math.abs(10-i));
            listNodes[i] = tmp;
        }
        new FunctionRunner(() ->{
            System.out.println("========= 解法2 ==========");
            //顺序合并链表
            new MergeKLists23().mergeKLists2(listNodes);
        }).run();
        for(int i =0;i<size;i++){
            //构造升序链表数组
            ListNode tmp = ListNode.createEasyRiseListNode(-i*500,i,10000*Math.abs(10-i));
            listNodes[i] = tmp;
        }
        new FunctionRunner(() ->{
            System.out.println("========= 解法3 ==========");
            //分治合并链表 平均合并的链表长度相似，时间复杂度相比顺序合并要好
            new MergeKLists23().mergeKLists3(listNodes);
        }).run();
        for(int i =0;i<size;i++){
            //构造升序链表数组
            ListNode tmp = ListNode.createEasyRiseListNode(-i*500,i,10000*Math.abs(10-i));
            listNodes[i] = tmp;
        }
        new FunctionRunner(() ->{
            System.out.println("========= 解法4 ==========");
            //借助优先队列（堆）原理合并
            new MergeKLists23().mergeKLists4(listNodes);
        }).run();
    }

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists4(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }


    public ListNode mergeKLists3(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }


    /**
     * 每次循环所有节点，筛选出最小的链表头并组装链表
     * 时间复杂度极差
     * */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode current = null;
        while(true){
            int min = 100000;
            int minIndex = -1;

            for(int i =0; i<lists.length ;i++){
                ListNode node = lists[i];
                if(node == null){
                    continue;
                }
                if(node.val<min){
                    min = node.val;
                    minIndex = i;
                }
            }
            if(minIndex>-1){
                if(null == result){
                    result = lists[minIndex];
                    lists[minIndex] = lists[minIndex].next;
                    current = result;
                    current.next = null;
                }else{
                    current.next = lists[minIndex];
                    lists[minIndex] = lists[minIndex].next;
                    current = current.next;
                    current.next = null;
                }
            }else{
                break;
            }
        }
        return result;
    }
}
