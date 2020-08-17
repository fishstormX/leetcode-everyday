package faceoffer.III;

import aspect.FunctionRunner;
import faceoffer.II.MinArray11;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
。
 * */
public class Exchange21 {
    public static void main(String args[]) throws InterruptedException {

        int[] nums = {9154,813,5823,5929,9852,5149,6315,7193,6220,9480,8983,8645,3045,9680,8103,4585,3213,1145,3297,9350,5499,9248,
                4148,1367,356,9849,8430,1421,1855,787,5241,2297,6665,9512,9791,1758,8115,5258,3297,282,8061,805,1086,
                8768,3297,9944,9338,6452,7941,8361,3483,5547,2696,7632,7422,2094,4916,8275,7552,8417,6891,803,3536,6844,
                796,7674,3324,2316,1710,5736,3324,6999,9528,4357,8495,3089,6661,1569,3614,769,5224,3648,1216,8083,6169,3094,
                5113,6908,5210,7679,690,3214,6955,5120,1770,8827,6450,9652,420,3579,3943,7936,5948,1177,5706,5990,1888,1451,
                2416,2947,4831,9017,659,3213,5098,1670,8068,4834,4148,4000,6275,1735,54,3604,8021,1681,3465,4402,4998,9544,4865,
                4447,1640,1110,3317,3891,1796,2170,880,7840,312,2533,7234,4273,5136,5814,8741,910,3319,9390,6622,675,4495,1840,8901,
                6884,9654,2210,9428,3459,7410,9282,330,1598,4560,9832,7214,1728,9049,7756,2798,2468,2148,2549,7068,6600,3231,4693,719,8189};
        int[] nums2 = {9154,813,5823,5929,9852,5149,6315,7193,6220,9480,8983,8645,3045,9680,8103,4585,3213,1145,3297,9350,5499,9248,
                4148,1367,356,9849,8430,1421,1855,787,5241,2297,6665,9512,9791,1758,8115,5258,3297,282,8061,805,1086,
                8768,3297,9944,9338,6452,7941,8361,3483,5547,2696,7632,7422,2094,4916,8275,7552,8417,6891,803,3536,6844,
                796,7674,3324,2316,1710,5736,3324,6999,9528,4357,8495,3089,6661,1569,3614,769,5224,3648,1216,8083,6169,3094,
                5113,6908,5210,7679,690,3214,6955,5120,1770,8827,6450,9652,420,3579,3943,7936,5948,1177,5706,5990,1888,1451,
                2416,2947,4831,9017,659,3213,5098,1670,8068,4834,4148,4000,6275,1735,54,3604,8021,1681,3465,4402,4998,9544,4865,
                4447,1640,1110,3317,3891,1796,2170,880,7840,312,2533,7234,4273,5136,5814,8741,910,3319,9390,6622,675,4495,1840,8901,
                6884,9654,2210,9428,3459,7410,9282,330,1598,4560,9832,7214,1728,9049,7756,2798,2468,2148,2549,7068,6600,3231,4693,719,8189};
        Exchange21 e = new Exchange21();
        new FunctionRunner(() ->{
            e.exchange(nums);
        }).run();

        new FunctionRunner(() ->{
            e.exchange2(nums2);
        }).run();
    }
    /**
     * end从后往前，start从前往后，避免了一些没必要的比较
     * */
    public int[] exchange(int[] nums) {
        boolean flag = false;
        int end=nums.length-1;
        for(int start = 0; start <nums.length; start++){
            if(nums[start]%2==0){
                for(; end> start; end--){
                    if(end== start){
                        return nums ;
                    }
                    if(nums[end]%2==1){
                        int tmp = nums[start];
                        nums[start] = nums[end];
                        nums[end] = tmp;
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    return nums;
                }
            }
        }
        return nums;
    }
    /**
     * 并非首尾指针，并且实际的性能和易读性差一些
     * */
    public int[] exchange2(int[] nums) {
        boolean flag = false;
        int end=0;
        for(int start=0;start<nums.length;start++){
            if(nums[start]%2==0){
                if(end<start){
                    end=start;
                }
                for(;end<nums.length;end++){
                    if(nums[end]%2==1){
                        int tmp = nums[start];
                        nums[start] = nums[end];
                        nums[end] = tmp;
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    return nums;
                }
            }
        }
        return nums;
    }
}
