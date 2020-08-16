package faceoffer.II;


import aspect.FunctionRunner;
import faceoffer.I.FindRepeatNumber3;

/***
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class MinArray11 {
    public static void main(String args[]){
        int[] nums = {3,4,5,1,2};
        new FunctionRunner(() ->{
            System.out.println(new MinArray11().minArray(nums));
        }).run();

    }
    /**
     * 单纯考察二分法，不要用遍历
     * */   
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            //只要右边比中间大，那右边一定是有序数组
            if (numbers[r] > numbers[mid]) {
                r = mid;
            } else if (numbers[r] < numbers[mid]) {
                l = mid + 1;
                //去重
            } else r--;
        }
        return numbers[l];
    }
}
