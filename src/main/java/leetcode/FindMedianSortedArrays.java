package leetcode;

import org.junit.Test;

public class FindMedianSortedArrays {

    @Test
    public void test(){
        System.out.print(findMedianSortedArrays(new int[]{},new int[]{1}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length=nums1.length+nums2.length;
        int index=2;
        boolean flag=true;
        if(length%2==1){
            flag=false;
        }
        for(int i=0;i<nums1.length;){
            for(int j=0;j<nums2.length;){
                if(i>=nums1.length){
                    return flag?nums2[length/2-1-nums1.length]+Math.max(nums2[length/2-nums1.length],nums1[--i]):nums2[length/2-nums1.length];
                }
                if(j>=nums2.length){
                    return flag?nums2[length/2-1-nums2.length]+nums2[length/2-nums2.length]:nums2[length/2-nums2.length];
                }
                if(i+j+2>length/2){
                    if(flag){
                        return (nums1[i]+nums2[j])/2;
                    }else{
                        return Math.max(nums1[i],nums2[j]);
                    }
                }
                if(nums1[i]<nums2[j]){
                    i++;
                }else {
                    j++;
                }
            }
        }
        return 0;
    }
}
