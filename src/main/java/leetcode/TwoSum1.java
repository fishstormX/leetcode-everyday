package leetcode;


import aspect.FunctionRunner;
import aspect.ListUtil;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class TwoSum1{

    public static void main(String args[]){
        TwoSum1 twoSum1 = new TwoSum1();
        int[] array=new int[10000];
        for(int q=0;q<10000;q++){
            array[q]=q;
        }
        int[] finalArray = array;
        new FunctionRunner(() ->{
            int a[] = twoSum1.twoSum(finalArray,19997);
            System.out.print("运行结果：");
            ListUtil.printArray(a);
        }).run();


        array=new int[10000];
        for(int q=0;q<10000;q++){
            array[q]=q;
        }
        int[] finalArray1 = array;
        new FunctionRunner(() ->{
            int a[] = twoSum1.twoSum2(finalArray1,19997);
            System.out.print("运行结果：");
            ListUtil.printArray(a);
        }).run();


    }



    /**
     * 普通解法，利用两索引遍历，
     * 时间复杂度较高
     * 时间复杂度最大为O((n*n-1)/2) ≈ O(n^2/2)
     * */
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    /**
     * 一次循环间建立hash表，加快索引速度
     * 时间复杂度最大约为O(n)
     * */
    public int[] twoSum2(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }

        return indexs;
    }
}
