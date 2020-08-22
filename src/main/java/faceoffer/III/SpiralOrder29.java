package faceoffer.III;

import aspect.FunctionRunner;
import aspect.ListUtil;
import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 */
public class SpiralOrder29 {

    public static void main(String args[]){

        new FunctionRunner(() ->{
            int[][] i= {{1,2,3},{4,5,6},{7,8,9}};
            ListUtil.printArray(new SpiralOrder29().spiralOrder(i));
        }).run();

    }
    /**
     * 一步一步去走即可，主要是 烦
     * */
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int[] result = new int[matrix.length*matrix[0].length];
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length -1;
        int index = 0;
        while(true){
            for(int i = y1;i<=y2;i++){
                result[index] = matrix[x1][i];
                index++;
            }
            x1++;
            if(index==result.length){
                break;
            }
            for(int i = x1;i<=x2;i++){
                result[index] = matrix[i][y2];
                index++;
            }
            y2--;
            if(index==result.length){
                break;
            }
            for(int i = y2;i>=y1;i--){
                result[index] = matrix[x2][i];
                index++;
            }
            x2--;
            if(index==result.length){
                break;
            }
            for(int i = x2;i>=x1;i--){
                result[index] = matrix[i][y1];
                index++;
            }
            y1++;
            if(index==result.length){
                break;
            }
        }
        return result;

    }


}
