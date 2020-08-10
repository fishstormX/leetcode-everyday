package faceoffer.I;

import aspect.FunctionRunner;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 * 示例 1：
 * 输入：n = 2
 * 输出：1
 *
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 *
 * 提示：
 * 0 <= n <= 100
 *
 */
public class Fib10A1 {

    public static void main(String args[]){
        new FunctionRunner(() ->{
            System.out.println(new Fib10A1().fib(37));
        }).run();

    }

    //简单的动态规划，为了避免不必要的计算，要从小到大的推，
    // 否则如果用递归n足够大时时间复杂度会很高
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        int pre=0;
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
