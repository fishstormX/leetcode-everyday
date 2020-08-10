package faceoffer.I;

import aspect.FunctionRunner;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 *  
 * 限制：
 *
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 *  
 * */
public class FindNumberIn2DArray4 {

    public static void main(String args[]){
        int[][] matrix = {{1,4,7,11,5},{2, 5, 8, 12, 19},{3, 6,  9, 16, 22},{10, 13, 14, 17, 24},{10, 13, 14, 17, 24},{18, 21, 23, 26, 3}};
        new FunctionRunner(() ->{
            System.out.println(new FindNumberIn2DArray4().findNumberIn2DArray(matrix,5));
        }).run();
        new FunctionRunner(() ->{
            System.out.println(new FindNumberIn2DArray4().findNumberIn2DArray1(matrix,5));
        }).run();

    }

    /**
     *
     * 剪枝的优化，假设从左上角进行遍历，当数组中数字>target时 我们便无法决定遍历的走向
     * 这也适用于从右下角向左上角遍历的情况，所以不防从右上角遍历，这样在行来说已经是最大值
     * 当出现matrix[x][y]>target时我们只需要把index左移 反之下移，每次直接刨除了右边所有列的数据
     * */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     *
     * 简单的解法 直接遍历 碰到大数结束当行的遍历
     * 此种解法不是最优，因为如果target较大，还是要对每行从0开始做过多的判断
     * */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target){
                    return true;
                }
                if(matrix[i][j]>target){
                    break;
                }
            }
        }
        return false;
    }
}
