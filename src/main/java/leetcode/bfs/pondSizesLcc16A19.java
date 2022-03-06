package leetcode.bfs;

import structure.Pair;

import java.util.*;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 *
 * 示例：
 *
 * 输入：
 * [
 *   [0,2,1,0],
 *   [0,1,0,1],
 *   [1,1,0,1],
 *   [0,1,0,1]
 * ]
 * 输出： [1,2,4]
 * 提示：
 *
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pond-sizes-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class pondSizesLcc16A19 {
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<land.length;i++){
            for(int j = 0;j<land[0].length;j++){
                if(land[i][j]==0){
                    land[i][j]=-1;
                    list.add(c(land,i,j));
                }
            }
        }
        Collections.sort(list);
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++) {
            result[i]=list.get(i);
        }
        return result;
    }
    /**
     * 从给定的(i,j)处开始BFS搜索，获取池塘大小
     * */
    private int c(int[][] land,int i ,int j){
        int count = 1;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        //初始点
        queue.offer(new Pair<>(i,j));
        while(queue.size()>0){
            Pair<Integer,Integer> pair = queue.poll();
            i=pair.getKey();
            j=pair.getValue();
            int i2 = i==land.length-1?i+1:i+2;
            int j2 = j==land[0].length-1?j+1:j+2;
            for(int p=i>0?i-1:i;p<i2;p++){
                for(int q=j>0?j-1:j;q<j2;q++){
                    if(land[p][q]==0){
                        land[p][q] = -1;
                        queue.offer(new Pair<>(p,q));
                        count++;
                    }
                }
            }
        }return count;
    }
}
