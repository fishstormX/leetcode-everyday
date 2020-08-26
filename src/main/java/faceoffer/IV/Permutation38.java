package faceoffer.IV;

import aspect.FunctionRunner;
import aspect.ListUtil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 *
 * 限制：
 * 1 <= s 的长度 <= 8
 *
 * */
public class Permutation38 {
    public static void main(String args[]) {
        new FunctionRunner(() -> {
            ListUtil.printArray(new Permutation38().permutation("asdtee"));
        }).run();
        new FunctionRunner(() -> {
            ListUtil.printArray(new Permutation38().permutation2("asdtee"));
        }).run();
    }

    /**
     * dfs递归 整体的交换思想其实与下面的dp是相同的，但是这种方式可以有效剪枝
     * 不易理解
     * */
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {

        if(x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x); // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1); // 开启固定第 x + 1 位字符
            swap(i, x); // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }


    /**
     * 使用两个set 正向dp 时间复杂度不是很棒
     * */
    public String[] permutation2(String s) {
        if(s.length()==1){
            String[] result = new String[1];
            result[0] = s;
            return result;
        }
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        char[] cc=s.toCharArray();
        set.add(new String(cc[0]+""));
        for(int i =1;i<s.length();i++){
            set2 = new HashSet<>();
            for(String sb:set){
                for(int j=0;j<i+1;j++){
                    set2.add( sb.substring(0,j)+cc[i]+sb.substring(j));
                }
            }
            set = set2;
        }
        String result[] = new String[set.size()];
        int i = 0;
        for(String sb:set){
            result[i] = sb;
            i++;
        }
        return result;
    }
}
