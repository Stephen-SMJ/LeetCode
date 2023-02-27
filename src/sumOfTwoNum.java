import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class sumOfTwoNum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for(int i=0; i < nums.length; i++){
			if (hashMap.containsKey(target - nums[i])){
				return new int[]{hashMap.get(target-nums[i]),i};
			}
			hashMap.put(nums[i],i);
		}
		return new int[0];
	}

	public static void main(String[] args) {
		sumOfTwoNum sumOfTwoNum = new sumOfTwoNum();
		int[] arr = new int[]{2,7,11,15};
		int tar = 17;
		System.out.println(Arrays.toString(sumOfTwoNum.twoSum(arr, tar)));
	}
}
