package jianzhi;

import java.util.ArrayList;

public class fib {
    public static int fib_curur(int n) { //递归leetcode过不了
        int[] tempArr = new int[101];
        if (n < 2){
            return n;
        } else if (tempArr[n] != 0){
            return tempArr[n];
        }
        tempArr[n] = (fib_curur(n-1) + fib_curur(n-2)) % 1000000007;
        return tempArr[n];
//        tempArr.set(n,(fib(n-1) + fib(n-2)) % 1000000007);
//        return tempArr.get(n);
    }

    public static int fib(int n) { //动态规划
        int sum = 0;
        int a = 0;
        int b = 1;
        for (int i=0; i<n; i++){
            sum = (a + b) % 1000000007;;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}
