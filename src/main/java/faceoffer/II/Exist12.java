package faceoffer.II;

import aspect.FunctionRunner;
import structure.ListNode;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200

 * */
public class Exist12 {
    public static void main(String args[]){
        new FunctionRunner(() ->{
            char board[][]={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
            String word = "ABCESEEEFS";
            System.out.println("复制数组方法:"+new Exist12().exist2(board,word));
        }).run();


        new FunctionRunner(() ->{
            char board[][]={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
            String word = "ABCESEEEFS";
            System.out.println("剪枝后还原方法:"+new Exist12().exist(board,word));
        }).run();
    }


    public boolean exist(char[][] board, String word) {
        char[] cs = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==cs[0]){
                    boolean x = isexist(board,cs,i,j,0);
                    if(x){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isexist(char[][] board, char[] cs,int x,int y ,int index){
        if(x<0||x>board.length-1||y<0||y>board[0].length-1){
            //交由此处判断 代码没那么繁琐
            return false;
        }
        //结束 中间有一步不一致
        if(board[x][y]!=cs[index]){
            return false;
        }
        //结束 到了最后一步
        if(index==cs.length-1){
            return board[x][y]==cs[index];
        }else{
            //剪枝
            char xy = board[x][y];
            board[x][y]='-';
            boolean tmp = isexist(board,cs,x-1,y,index+1)||isexist(board,cs,x+1,y,index+1)||
                    isexist(board,cs,x+1,y,index+1)||isexist(board,cs,x,y+1,index+1);
            board[x][y]=xy;
            return tmp;
        }
    }




    /**
     * 不好的解法：
     * 通过每一步操作重新复制出一份board然后修改来剪枝
     * 时间复杂度简直低到不行，不可取
     * */
    public boolean exist2(char[][] board, String word) {
        char[] cs = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==cs[0]){
                    boolean x = isexist2(copyArray(board),cs,i,j,0);
                    if(x){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isexist2(char[][] board, char[] cs,int x,int y ,int index){
        //结束 中间有一步不一致
        if(board[x][y]!=cs[index]){
            return false;
        }
        //结束 到了最后一步
        if(index==cs.length-1){
            return board[x][y]==cs[index];
        }else{
            //剪枝
            board[x][y]=' ';
            if(x>0){
                //为了防止剪枝影响到其他递归，只能复制数组
                boolean a = isexist2(copyArray(board),cs,x-1,y,index+1);
                if(a){
                    return true;
                }
            }
            if(x<board.length-1){
                boolean a = isexist2(copyArray(board),cs,x+1,y,index+1);
                if(a){
                    return true;
                }
            }
            if(y>0){
                boolean a = isexist2(copyArray(board),cs,x,y-1,index+1);
                if(a){
                    return true;
                }
            }
            if(y<board[0].length-1){
                boolean a = isexist2(copyArray(board),cs,x,y+1,index+1);
                if(a){
                    return true;
                }
            }
        }
        return false;
    }

    private char[][] copyArray(char[][] ori){
        char[][] target = new char[ori.length][ori[0].length];
        for(int i = 0; i < ori.length; i++){
            System.arraycopy(ori[i], 0, target[i], 0, ori[0].length);
        }
        return target;
    }
}
