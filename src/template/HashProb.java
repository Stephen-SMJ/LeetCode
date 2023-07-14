package template;

import sun.font.CreatedFontTracker;

import java.util.*;
import java.util.stream.IntStream;

public class HashProb {
    /*
    当题目中有判断xxx是否存在类的问题想到用哈希结构。
    遍历hash结构用增强for循环 for(int i:set)
     */
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i=0; i<s.length(); i++){
            record[s.charAt(i) - 'a']++;
        }

        for(int i=0; i<t.length(); i++){
            record[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<record.length; i++){
            if(record[i] != 0)
                return false;
        }
        return true;


    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length==0 || nums2.length==0)
            return new int[0];
        HashSet<Integer> section = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for (int i:nums1)
            section.add(i);

        for (int i:nums2){
            if (section.contains(i))
                resSet.add(i);
        }
        int[] result = new int[resSet.size()];
        int i=0;
        for(int j : resSet){
            result[i] = j;
            i++;
        }

//   或者     result.stream().mapToInt(x -> x).toArray();

        return result;
    }


    public boolean isHappy(int n) {

        /*
        %从后面取，/从前面取
        1865 % 10 = 5 个位
        1865 / 10 = 186
         */
        HashSet<Integer> records = new HashSet<>();

        while (n != 1 && !records.contains(n)){
            records.add(n);
            n = getSum(n);
        }
        return n==1;

    }
    private int getSum(int n){
        int res = 0;
        while(n > 0){
            int last = n % 10;
            res += last*last;
            n = n/10;
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> record = new HashMap();
        for (int i=0; i<nums.length; i++){
            if (record.containsKey(target - nums[i])){
                return new int[]{record.get(target - nums[i]),i};
            }
            record.put(nums[i], i); //2 1
        }
        return null;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res=0;
        Map<Integer, Integer> record = new HashMap();
        for (int a:nums1){
            for (int b:nums2){
                record.put(a+b, record.getOrDefault(a+b,0)+1); //getOrDefault()，如果不存在key，则复默认值为0.
                //哈希map太慢。字符串可以用数组+ascii码解决。record[magazine.charAt(i) - 'a']++;
            }
        }

        for (int c:nums3){
            for(int d:nums4){
                if (record.containsKey(-(c+d))){
                    res++;
                }
            }
        }
        return res;


    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> record = new HashMap<>();
        for(int i=0; i<magazine.length(); i++){
            record.put(magazine.charAt(i), record.getOrDefault(magazine.charAt(i),0)+1);
        }

        for (int j=0; j<ransomNote.length(); j++){
            if (!record.containsKey(ransomNote.charAt(j)))
                return false;
            else {
                record.put(ransomNote.charAt(j), record.get(ransomNote.charAt(j))-1);
                if(record.get(ransomNote.charAt(j))<0){
                    return false;
                }
            }
        }
        return false;

    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            if (nums[i] > 0) {
                return res;
            }
            if (i>0 && nums[i]==nums[i-1]) //对a去重，因为每次j，k都是重新开始，所以有可能重复。 {-1,-1,0,1,2}跟第一个-1组合为0的，第二个-1也可以为0.
                continue;
            int j=i+1;
            int k=nums.length-1;
            while (k>j){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum>0) {
                    k--;
                }else if (sum<0) {
                    j++;
                }else {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (k>j && nums[j]==nums[j+1])  //对j，k去重
                        j++;
                    while (k>j && nums[k]==nums[k-1])
                        k--;
                    k--;
                    j++;
                }
            }
        }
        return res;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            if (nums[i] >= 0 && nums[i] > target) //-5 -4 -10
                return result;
            if (i>0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<nums.length; j++){
                if (nums[j]+nums[i] >= 0 && nums[j] + nums[i] > target)
                    return result; //不能return result: j走完i还要走，break只退出一层。
                if (j>i+1 && nums[j] == nums[j-1])
                    continue;
                int left = j+1;
                int right = nums.length-1;
                while (right > left){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum>target){
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(right > left && nums[right] == nums[right-1]) right--;
                        while(right > left && nums[left] == nums[left+1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        canConstruct("aa","aab");
        int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};
        fourSum(nums,0);
    }
}
