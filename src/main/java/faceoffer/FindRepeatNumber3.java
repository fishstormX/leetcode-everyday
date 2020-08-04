package faceoffer;

import aspect.FunctionRunner;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 剑指Offer 3
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * */
public class FindRepeatNumber3 {

    public static void main(String args[]){
        int[] nums = {2, 1, 5, 12, 7,4, 6, 3, 5, 10, 11, 8, 7, 9};
        new FunctionRunner(() ->{
            System.out.println(new FindRepeatNumber3().findRepeatNumber(nums));
        }).run();
        new FunctionRunner(() ->{
            System.out.println(new FindRepeatNumber3().findRepeatNumber1(nums));
        }).run();
    }
    /**
     * 此解法基于前提：长度n的数组中的数字在0~n-1范围内
     * 基于这个前提 可以使用原地交换，主要节省了HashSet使用的时间复杂度
     * 书中的解法：从头到尾扫描数组 ，当扫描到i位置时,假定m = nums[i],则
     * 如果nums[i] == 1继续扫描 ，反之比较其与第m个数字比较（return）或交换
     *
     *
     * 时间复杂度与示例2相同 胜在了API时间和空间利用，当然也要看具体的数组
     *
     *
     * 构建 nums[i] = i 的数组的同时找到答案
     * */
    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                swap(nums,i,nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    /**
     * 普通解法 借助一个哈希表去重
     * */
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int i :nums){
            if(!set.add(i)){
                return i;
            }
        }
        return 0 ;
    }
}
