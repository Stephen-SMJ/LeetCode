package jianzhi;

/*
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 */
public class exist {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (dfs(board, words, i, j ,0))
                    return true;
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, char[] words, int i, int j, int k){
        if (i < 0 || j < 0 || i >= board.length || j > board[0].length || board[i][j] != words[k])
            return false;
        if (k == words.length-1)
            return true;

        if (board[i][j] == words[k])
            board[i][j] = '\0';

        boolean res = dfs(board, words, i+1, j,k+1) || dfs(board, words, i-1, j ,k+1)
                || dfs(board, words, i, j+1 ,k+1) || dfs(board, words, i, j-1 ,k+1);

        board[i][j] = words[k];

        return res;

    }
}
