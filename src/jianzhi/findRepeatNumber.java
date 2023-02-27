package jianzhi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class findRepeatNumber {
	public static int findRepeatNumber(int[] nums){
		HashMap<Integer, Integer> numSets = new HashMap<>();
		for (int i = 0; i <= nums.length; i++){
			if (numSets.containsKey(nums[i])){
				return nums[i];
			}
			numSets.put(nums[i],1);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 0, 2, 5, 3};
		System.out.println(findRepeatNumber.findRepeatNumber(nums));
	}
}
