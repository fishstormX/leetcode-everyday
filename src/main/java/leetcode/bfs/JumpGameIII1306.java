package leetcode.bfs;

import aspect.FunctionRunner;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。
 * 当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * 示例 1：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class JumpGameIII1306 {
    public boolean canReach(int[] arr, int start) {
        //上来就是0
        if(arr[start]==0){
            return true;
        }
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(start,arr[start]));
        while(queue.size()>0){
            int size = queue.size();
            for(int i =0;i<size;i++){
                Pair<Integer, Integer> j  = queue.poll();
                int key = j.getKey();
                int value = j.getValue();
                if(value ==0){
                    return true;
                }
                //向后跳
                if(key+value<arr.length&&arr[key+value]>-1){
                    if(arr[key+value] ==0){
                        return true;
                    }
                    queue.offer(new Pair<Integer,Integer>(key+value,arr[key+value]));
                    arr[key+value] = -1;
                }
                //向前跳
                if(key-value>-1&&arr[key-value]>-1){
                    if(arr[key-value] ==0){
                        return true;
                    }
                    queue.offer(new Pair<Integer,Integer>(key-value,arr[key-value]));
                    arr[key-value] = -1;
                }
            }
        }
        return false;
    }


    public static void main(String args[]){
        int arr[] = {4,2,3,0,3,1,2};
        int start =5;
        new FunctionRunner(() ->{
            JumpGameIII1306 jumpGameIII1306 = new JumpGameIII1306();
            System.out.println(jumpGameIII1306.canReach(arr,start));
        }).run();

    }
}
