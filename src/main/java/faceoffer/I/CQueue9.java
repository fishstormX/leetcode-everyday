package faceoffer.I;

import aspect.FunctionRunner;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *  
 * 示例 1：
 * 输入：
 * ["CQueue9","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue9","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * */
public class CQueue9 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /**
     * 每次要出队列时，将两个stack倒一下即可
     * */
    public static void main(String args[]){
        new FunctionRunner(() ->{
            CQueue9 cQueue = new CQueue9();
            cQueue.appendTail(3);
            System.out.println(" push 3："+cQueue);
            cQueue.appendTail(6);
            System.out.println(" push 6："+cQueue);
            cQueue.appendTail(9);
            System.out.println(" push 9："+cQueue);
            System.out.println(" pop  "+cQueue.deleteHead()+"："+cQueue);
            cQueue.appendTail(5);
            System.out.println(" push 5："+cQueue);
            System.out.println(" pop  "+cQueue.deleteHead()+"："+cQueue);
            System.out.println(" pop  "+cQueue.deleteHead()+"："+cQueue);
            System.out.println(" pop  "+cQueue.deleteHead()+"："+cQueue);
            System.out.println(" pop  "+cQueue.deleteHead()+"："+cQueue);
        }).run();

    }

    public CQueue9() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.empty()){
            if(stack1.empty()){
                return -1;
            }
            int i = stack1.size();
            for(int q = 0;q<i;q++){
                Integer s = stack1.pop();
                stack2.push(s);
            }
        }
        Integer z = stack2.pop();
        return z;
    }

    public String toString(){
        return stack1+"-"+stack2;
    }
}
