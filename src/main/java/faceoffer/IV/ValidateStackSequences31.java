package faceoffer.IV;

import aspect.FunctionRunner;
import aspect.ListUtil;

/**
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *  
 *
 * 提示：
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 *
 */
public class ValidateStackSequences31 {

    public static void main(String args[]){

        new FunctionRunner(() ->{
            int pushed[] = {0,3,6,5,9,7,1,4,8,2};
            int popped[] = {6,5,1,7,2,8,4,9,3,0};
            System.out.println((new ValidateStackSequences31().validateStackSequences(pushed,popped)));
        }).run();

    }
    /**
     * 按逻辑自己捋，代码可能有点繁琐，逻辑不难理解
     * 第一个出栈值比较随意，此后在此值之前的数均已经入栈，所以只能倒序输出，在之后的值不受限制
     * 所以一个出栈的要么在刚刚出栈的数后面 要么挨着刚刚出栈的数
     * 所以设置两值分别记录 前和后点，并且要注意已经出栈的置为-1,
     * */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length<2){
            return true;
        }
        int index = 0;
        int start = 0;
        int end = 0;
        while(index <popped.length-1){
            boolean flag=false;
            if(pushed[start] == popped[index]){
                pushed[start] = -1;
                if(start!=0){
                    for(int i = start-1;i>=0;i--){
                        if(pushed[i]!=-1){
                            start = i;
                            break;
                        }
                    }
                }
                index++;
                continue;
            }
            for(int i=end;i<pushed.length ;i++){
                if(pushed[i] == popped[index]){
                    pushed[i] =  -1;
                    index++;
                    end=i+1;
                    if(i==0){
                        flag = true;
                        break;
                    }else{
                        for(int j = i-1;j>=0;j--){
                            if(pushed[j]!=-1){
                                start = j;
                                break;
                            }
                        }
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }


}
