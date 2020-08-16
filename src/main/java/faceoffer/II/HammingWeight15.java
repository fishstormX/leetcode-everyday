package faceoffer.II;

import aspect.FunctionRunner;

/**
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 * */
public class HammingWeight15 {

    public static void main(String args[]){
        new FunctionRunner(() ->{
            //1111 1111 1111 1111 1111 1111 1111 1101
            System.out.println(new HammingWeight15().hammingWeight(-3));
        }).run();

    }
    /***
     * 两点共识
     * 1.x二进制末尾为0 ，则x&1=0,反之x&1=1
     * 2.无符号位二进制右移最终结束在x=0
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int z=n;
        int x=0;
        while(z!=0){
            if((z&1)>0){
                x++;
            }
            z >>>= 1;
        }
        return x;
    }
}
