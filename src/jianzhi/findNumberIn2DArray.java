package jianzhi;

import java.util.ArrayList;

public class findNumberIn2DArray {
	//arr.length 代表二位数组的大小/元素个数/一维数组的个数，行数；
	//arr[0].length 代表二维数组第一个元素/一维数组的大小，列数。
	public static boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (matrix[0].length == 0){
			return false;
		}
		for (int i = 0; i<matrix.length; i++){
			if (target > matrix[i][matrix[0].length-1]){
				continue;
			}
			for (int j = 0; j<=matrix[0].length-1; j++){
				if (matrix[i][j] == target){
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = {
				{}
		};
		System.out.println(matrix[0].length);
		//System.out.println(findNumberIn2DArray.findNumberIn2DArray(matrix,-5));

//		System.out.println(matrix.length);
//		System.out.println(matrix[0].length);

	}
}
