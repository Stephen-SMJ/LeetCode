import java.util.Arrays;

public class generateMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int startx= 0;
        int starty = 0;
        int loop = 0;
        int count = 1;
        int i,j;

        while(loop++ < n/2){
            i = startx;
            j = starty;
            for (; j<n-loop; j++){
                matrix[i][j] = count++; //0,0 1
            }
            for (; i<n-loop; i++){
                matrix[i][j] = count++; //0,1 2
            }
            for(; j>starty; j--){
                matrix[i][j] = count++; //1,1 3
            }
            for(; i>startx; i--){
                matrix[i][j] = count++; //1,0 4
            }
            startx++;
            starty++;
        }
        if(n==1 || n%2==1){
            matrix[n/2][n/2] = count++;
        }
        return matrix;
    }

    public static void main(String[] args) {  //遍历矩阵：双层循环，mar.length是行数，mar[i].length表示第i列的数量，都相等所以直接用mar[0].length
        int[][] mar = generateMatrix(4);
        for (int i=0; i<mar.length; i++){
            for (int j=0; j<mar[1].length; j++){
                System.out.println(mar[i][j]);
            }

        }


    }
}
