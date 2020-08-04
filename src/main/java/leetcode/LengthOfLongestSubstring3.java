package leetcode;

import aspect.FunctionRunner;


/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class LengthOfLongestSubstring3 {

    public static void main(String args[]){
        String s="pwwkew";
        new FunctionRunner(() ->{
            System.out.println(s+":"+new LengthOfLongestSubstring3().lengthOfLongestSubstring(s));
        }).run();
    }


    /**
     * 动态规划
     * 双索引遍历
     * 记录到当前位置的最长字符和到当前位置，
     * 时间复杂度最大为O( (n*n-1)/2 )
     * */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int from =0;
        for (int i=0;i<s.length();i++){
            char c =s.charAt(i);
            for(int j=from;j<i;j++){
                //发生重复 则从重复位置继续
                if(s.charAt(j)==c){
                    from=j+1;
                }
            }
            if((i+1-from)>max){
                max=(i+1-from);
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int l = 0;
        int [] dp = new int[s.length()+1];
        for(int i=0;i<s.length();i++){
            if(s.substring(l,i).indexOf(s.charAt(i))!=-1){
                l = s.indexOf(s.charAt(i), l)+1;
            }
            dp[i+1] = Math.max(dp[i], i-l+1);
        }
        return dp[s.length()];
    }
}
