package template;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DoublePointer {
    /*
    * 常见于数组，链表。LeetCode27. 移除元素 26.删除排序数组中的重复项 283.移动零 844.比较含退格的字符串 977.有序数组的平方
    * 双指针：java1中不存在指针，这里的指针就是index，一个数组下标，快指针可以从开始，具体看问题设计。
    * 题目关键词：空间复杂度O(1)，必须在不复制数组的情况下原地对数组进行操作。
    * 通常来说，题目中包含对元素数量的计算要求时，用一个循环解决两个循环才能解决的事情就可以用双指针，例如快慢指针。
    * 字符串类型题有时候指针可以从右边开始。
    * */

    public static int removeElement(int[] nums, int val) {
        int slowIndex  = 0;
        for (int fastIndex=0; fastIndex<nums.length; fastIndex++){
            if(nums[fastIndex]!=val)
                nums[slowIndex ++]=nums[fastIndex];
        }
        return slowIndex ;
    }

    public int removeDuplicates(int[] nums) {
        int slow=0;
        boolean flag=true; //判断fast和slow不一样
        for (int fast=1; fast < nums.length; fast++){
            flag = nums[fast]==nums[slow] ? false:true;
            if(flag)
                nums[++slow] = nums[fast];
        }
        return ++slow; //slow从0开始，要返回的是个数，所以+1
    }

    public static void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        for(;j<nums.length;j++){
            nums[j]=0;
        }
    }

    public boolean backspaceCompare(String s, String t) { //字符串类型题有时候指针可以从右边开始。
        return back(s).equals(back(t));
    }
    public static String back(String s){
        char[] schar = s.toCharArray();
        int score = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i>=0; i--){
            if (schar[i] == '#'){
                score++;
            } else {
                if (score != 0){
                    score--;
                }else {
                    sb.append(schar[i]);
                }
            }
        }
        return sb.toString();
    }

    public static int[] sortedSquares(int[] nums) {
        int k=nums.length-1;
        int[] newNums = new int[nums.length];
        for(int i=0, j=nums.length-1; i<=j;){
            if (nums[i]*nums[i] >= nums[j]*nums[j]){
                newNums[k--] = nums[i] * nums[i];
                i++;
            }
            else {
                newNums[k--] = nums[j] * nums[j];
                j--;
            }

        }
        IntStream sorted = Arrays.stream(newNums).sorted();
        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,2,3,10};
        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result));

    }
}
