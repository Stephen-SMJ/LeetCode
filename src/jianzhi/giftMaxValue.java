package jianzhi;

public class giftMaxValue {
    public int maxValue(int[][] grid) {
        int row = grid.length; //二维数组默认是行，0是列
        int col = grid[0].length;
        int[][] dp = new int[row+1][col+1]; //多加一行一列能避免掉边界值问题.
        for (int i=1; i <= row; i++){
            for (int j=1; j <= col; j++){
                dp[i][j] = Math.max(grid[i-1][j],grid[i][j-1]) + grid[i-1][j-1]; //dp比grid多一维，最后一个格子时,dp[3][3],grid[2][2]
            }
        }

        return dp[row][col];
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        System.out.println(b.compareTo(a));
    }
}
