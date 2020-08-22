package faceoffer.III;

import aspect.FunctionRunner;
import aspect.ListUtil;

import java.util.Stack;

/***
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 *  
 *
 * */
public class MinStack30 {

    public static void main(String args[]){
        new FunctionRunner(() ->{
            MinStack30 minStack30 = new MinStack30();
            minStack30.push(-2);
            minStack30.push(0);
            minStack30.push(-3);
            System.out.println(minStack30.min());
            minStack30.pop();
            System.out.println(minStack30.top());
            System.out.println(minStack30.min());

        }).run();

    }

    private Stack<Integer> stack;
    private Stack<Integer> stack2;
    /**
     * 同时维护两套stack 一个存数据 一个存放当前数据量的min值
     * */
    public MinStack30() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if(stack2.size()>0&&stack2.peek()<x){
            stack2.push(stack2.peek());
        }else{
            stack2.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        stack2.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
