package jianzhi;

import com.sun.org.apache.xml.internal.utils.PrefixResolverDefault;

public class minArray {
    public int minArray(int[] numbers) {
        // 1 2 2 4 5 6 --> 旋转点在右边：2 4 5 6 1 2 nums[mid] > nums[right]  | 旋转点在左边 ：5 6 1 2 2 4 nums[mid] < nums[right]
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right){
           int mid = (left + right) / 2;
           if (numbers[mid] > numbers[right])
               left = mid + 1;
           else if(numbers[mid] < numbers[right])
               right = mid;
           else //等于的情况没办法判断，只能线性遍历
               return findMin(numbers, left, right);
        }
        return numbers[left];
    }
    public int findMin(int[] numbers, int left, int right){
        int min = numbers[0];
        for (int number : numbers) {
            if (number <= min)
                min = number;
        }
        return min;
    }

}
