package jianzhi;
/*
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
因为3+5+3+8=19。请问该机器人能够到达多少个格子？

数位之和计算：
设一数字 x ，向下取整除法符号 /, 求余符号 %
x % 10 ：得到 x 的个位数字
x / 10 ： 令 x 的十进制数向右移动一位，即删除个位数字。
 */
public class movingCount {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int count = dfs(0, 0, m, n, k, visited);
        return count;
    }

    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited){
        if (i >= m || j >= n || getSum(i) + getSum(j) > k || visited[i][j])
            return 0;
        visited[i][j] = true;
        return 1 + dfs(i+1, j, m, n, k, visited) + dfs(i, j+1, m, n, k, visited);

    }

    public int getSum(int a){
        int s = 0;
        while (a != 0){
            int x = a % 10;
            s += x;
            a = a / 10;
        }
        return s;
    }
}
