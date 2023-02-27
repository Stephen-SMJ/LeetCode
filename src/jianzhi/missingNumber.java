package jianzhi;

import java.util.Arrays;

public class missingNumber {

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == mid){  // 0 1 2 4 5
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
