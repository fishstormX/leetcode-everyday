package faceoffer.I;

import aspect.FunctionRunner;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 *
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 *
 * 提示：
 * 0 <= n <= 100
 *
 */
public class Upstairs10A2 {

    public static void main(String args[]){
        new FunctionRunner(() ->{
            System.out.println(new Upstairs10A2().upstairs(37));
        }).run();

    }

    /**
     *
     *
     * 基本同{@link Fib10A1},只是初始条件不同
     */
    public int upstairs(int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        int pre=1;
        int now=1;
        for (int i = 2; i < n+1; i++) {
            now = now + pre;
            pre = now - pre;
            if(now>1000000007)
                now%=1000000007;
        }
        return now;
    }
}
