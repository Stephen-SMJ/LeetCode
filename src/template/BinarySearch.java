package template;

public class BinarySearch {
    /* 时间复杂度：O(logN) 空间复杂度：O(1)
    记第一种就行
    第一种写法，我们定义 target 是在一个在左闭右闭的区间里，也就是[left, right]
    while (left <= right) 要使用 <= ，因为left == right是有意义的，所以使用 <=
    if (nums[middle] > target) right 要赋值为 middle - 1，因为当前这个nums[middle]一定不是target，
    那么接下来要查找的左区间结束下标位置就是 middle - 1;
     */
    /*
    二分查找类题目结论：
    看到 （给定一个按照升序排列的整数数组 nums），一定是二分查找。
    1. 插入正确位置，查找之后没有找到target的情况是 right _ left（相当于没找到的情况是打破循环，left > right），此时应该插入的位置是right+1。 left-1不行！;
    2. 找左右边界，写两个函数，别分用二分查找找左右边界，找左边界要用right（target>=nums[mid]），=时也要继续找， 找右边界用left。找到边界之后下一轮迭代会终止徐循环。
    3.找完全平方数或者求平方根等操作，本质上相当于在0-n之间搜索一个数a 满足a*a=n;


     */
    public static int binSearch1(int[] nums, int target){
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int left = 0;
        int right = nums.length;
        while(left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] < target) {
               left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binSearch2(int[] nums, int target){
        if (target < nums[0] || target > nums[nums.length-1])
            return -1;
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] > target){
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                return mid;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 0;
        System.out.println(binSearch2(nums,target));
    }
}
