package leetcode.dp;


import aspect.FunctionRunner;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 *  示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 *
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class UniquePaths62 {

    public static void main(String args[]){
        new FunctionRunner(() ->{
            //示例2
            System.out.println(new UniquePaths62().uniquePaths(7,3));
        }).run();

    }

    public int uniquePaths(int m, int n) {
        int[][] c=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0){
                    c[j][i]=1;
                }
                else{
                    c[j][i]=c[j-1][i]+c[j][i-1];
                }
            }
        }
        return c[m-1][n-1];
    }

     /*纯迭代 被【pass】时间过长
    public int uniquePaths(int m, int n) {
        if(m==1||n==1){
            return 1;
        }else{
            return uniquePaths( m-1,  n)+uniquePaths(m,  n-1);
        }
    }*/
}
